/******************************************************************************
Clase: Poligono.java
 ******************************************************************************/
package visujava;

import java.util.*;

/** Representa un Poligono con nVertices Vertices. */
public class Poligono {

    /** Numero de Vertices. */
    protected int nVertices;
    /** Vector de Vertices que pertenecen al Poligono. */
    protected ArrayList<Vertice> Vertices;
    /* Limites del poligono. */
    //final static int limRangoX = 200;
    //final static int limRangoY = 200;

    /** Contruye un Poligono por defecto (sin ningun Vertice). */
    public Poligono() {
        Vertices = new ArrayList<Vertice>();
        nVertices = 0;
    }

    /** Construye un Poligono con un numero de Vertices nV. */
    public Poligono(int nV) {
        Vertices = new ArrayList<Vertice>(nV);
        nVertices = nV;
    }

    /** Construye un Poligono como p1. Para ello se utiliza el metodo clone,
    sin necesidad de reservar memoria, ya que para usar este metodo no es
    necesario. */
    public Poligono(Poligono pl) {
        Vertices = (ArrayList<Vertice>) pl.Vertices.clone();
        nVertices = pl.nVertices;
    }

    /** Construye un Poligono con el numero de Vertice nV, los cuales estaran
    en el vector vert. */
    public Poligono(ArrayList<Vertice> vert, int nV) {
        Vertices = (ArrayList<Vertice>) vert.clone();
        nVertices = nV;
    }

    /** Devuelve una copia del Poligono actual. */
    public Poligono copia() {
        Poligono nuevoPoligono = new Poligono(nVertices);
        nuevoPoligono.Vertices = (ArrayList<Vertice>) Vertices.clone();
        nuevoPoligono.nVertices = nVertices;
        return nuevoPoligono;
    }

    /** Obtiene una copia del Poligono pl. */
    public void copia(Poligono pl) {
        Vertices.clear();                           //Se limpia el vector.
        Vertices = (ArrayList<Vertice>) pl.Vertices.clone();    //Se copia el vector.
        nVertices = pl.nVertices;
    }

    /** Establece el Vertice v en la posicion pos del Poligono actual. Teniendo
    en cuenta que el vector esta indexado desde 0. */
    public void modifica(Vertice v, int pos) {
        if (pos >= 0 && pos < nVertices) {
            Vertice antiguo = new Vertice((Vertice) Vertices.get(pos));
            antiguo.modificaPoligono(null);
            antiguo.modificaPosicion(-1);
            Vertices.set(pos, (Vertice) v);
            v.modificaPoligono(this);
            v.modificaPosicion(pos);
        }
    }

    /** Establece el v�rtice v en la �ltima posici�n del pol�gono actual. */
    public void anade(Vertice v) {
        Vertices.add((Vertice) v);
        v.modificaPoligono(this);
        v.modificaPosicion(nVertices);
        nVertices++;
    }

    /** Devuelve el v�rtice v que ocupa la posici�n pos. */
    public Vertice lee(int pos) {
        if (pos >= 0 && pos < nVertices) {
            return (Vertice) Vertices.get(pos);
        } else {
            return null;
        }
    }

    /** Devuelve una copia del v�rtice v que ocupa la posici�n pos. */
    public Vertice leeAsigna(int pos) {
        if (pos >= 0 && pos < nVertices) {
            return new Vertice((Vertice) Vertices.get(pos));
        } else {
            return null;
        }
    }

    /** Devuelve el n�mero de v�rtices que tiene el pol�gono. */
    public int numeroVertices() {
        return nVertices;
    }

    /** Muestra por pantalla la informaci�n del pol�gono. */
    public void out() {
        Vertice v = new Vertice();
        for (int i = 0; i < nVertices; i++) {
            v = (Vertice) Vertices.get(i);
            v.out();
        }
    }

    /******************** METODOS PROPIOS *******************/
    /**
     * Contructor que construye en poligono aleatorio
     * @param num Número de vértices
     * @param semilla Semilla de aleatoriedad
     */
    public Poligono(int num, int semilla) {//Con esta función no va a salir convexo casi nunca - revisar
        //Vamos a introducir los vertices del poligono ya ordenados
        Random rnd = new Random(semilla);
        
        //Creamos una serie de puntos en un array
        ArrayList<Vertice> nube = new ArrayList<Vertice>();
        
        for(int i=0;i< num;i++){
            nube.add(new Vertice(new Punto(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO))));
        }
        
        //Ordenamos por grados, teniendo como referencia el (0,-500)
        Collections.sort(nube,new ComparadorMin());
        
        ComparadorGrados.minimo = nube.get(0);
        
        //Ordenamos los puntos por ángulo
        Collections.sort(nube,new ComparadorGrados());
        
        //Alamcenamos los puntos
        Vertices = new ArrayList<Vertice>();
        nVertices = num;
        for(int i = 0;i < num;i++){
            Vertices.add(new Vertice(nube.get(i).leex(), nube.get(i).leey(), this, i));
        }
        
        
    }    

    /**
     * Calcula centroide (medias de X, e Y)
     * @return el punto del centroide
     */
    public Punto centroide() {
        double totX = 0, totY = 0;
        for (int i = 0; i < nVertices; i++) {
            totX += lee(i).x;
            totY += lee(i).y;
        }

        return new Punto(totX / nVertices, totY / nVertices);
    }

    /**
     * Área del poligono
     * @return Área
     */
    public double areaPoligono() {//Diviendo en triangulos
        Punto p = new Punto(0, 0);
        double area = 0;

        for (int i = 0; i < nVertices; i++) {
            area += p.areaTriangulo2(lee(i), lee((i + 1)%nVertices)) / 2;
        }
        
        return area;
    }

    private boolean intersectaDiagonal(int i, int j) {
        Segmento diagonal = new Segmento(lee(i), lee(j));

        for (int h = 0; h < nVertices; h++) {
            if (diagonal.intersecta(new Segmento(lee(h), lee(h % nVertices).siguiente()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Diagonal interna dadas dos posiciones (vertices)
     * @param a Número del vértice
     * @param b Número del vértice
     * @return True si es diagonal interna o False si no lo es
     */
    public boolean diagonalInterna(int i, int j) {
        if (convexo()) {
            if (lee(i).anterior().izquierda(lee(i % nVertices), lee(j % nVertices))
                    && lee(i).siguiente().derecha(lee(i % nVertices), lee(j % nVertices))) {
                return intersectaDiagonal(i, j);
            } else {
                return false;
            }
        } else { //Concavo
            if (!(lee(i).siguiente().izquierdaSobre(lee(i % nVertices), lee(j % nVertices))
                    && lee(i).anterior().izquierdaSobre(lee(j % nVertices), lee(i % nVertices)))) {
                return intersectaDiagonal(i, j);
            } else {
                return false;
            }
        }
    }

    private boolean tangente(Vertice v, Vertice q) {
        return q.lee().izquierdaSobre(v.anterior(), v) ^ q.lee().izquierdaSobre(v, v.siguiente());
    }

    /**
     * Dice si la recta que pasa por los dos vértices es tangente a los polígonos
     * @param v1 (this)
     * @param v2 Posición del vertice que pertenece el poligono p
     * @param p Poligo que junto a this se va a comprobar si los vertices son tangentes
     * @return True si es tangente o False si no lo es
     */
    public boolean esTangente(int posV1, int posV2, Poligono p) {
        ArrayList<Vertice> A = (ArrayList<Vertice>) this.Vertices.clone();
        ArrayList<Vertice> B = (ArrayList<Vertice>) p.Vertices.clone();
        
        //Ordenamos de izquierda a derecha los dos poligonos
        Collections.sort(A,new ComparadorVerticeIzqDer());
        Collections.sort(B,new ComparadorVerticeIzqDer());
        
        int a = A.get(0).posicion; // Cogemos el mas a la derecha
        int b = B.get(B.size()-1).posicion; //Cogemos el más a la izquierda
        
        int aa = -2, bb = -2; //No pude coincidir con a y b
        do{
            aa = a;
            bb = b;
            while(!this.tangente(this.lee(a),p.lee(b))){
                a = (a-1 + this.nVertices) % nVertices;
            }
            while(! p.tangente(this.lee(a),p.lee(b))){
                b = (b+1) % p.nVertices;
            }
        }while(aa == a && bb == b);
        
        if(a == posV1 && b == posV2){
            return true;
        }else{
            return false;
        }
        
    }
//    public boolean esTangente(int posV1, int posV2, Poligono p) {
//        if (tangente(lee(posV1 % nVertices), p.lee(posV2 % p.nVertices))
//                && tangente(p.lee(posV2 % p.nVertices), lee(posV1 % nVertices))) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    /**
     * Polígono convexo
     * @return True si el polígono es convexo o False si no lo es
     */
    public boolean convexo() {
        for (int i = 0; i < nVertices; i++) {
            if (!lee(i).convexo()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Intersección entre poligonos convexos
     * @param p
     * @return El poligono intersección de los dos polígonos
     */
    public Poligono intersecta(Poligono p) {
        return null;
    }
    /**
     * Determina si un punto está contiene del polígono
     * @param pt
     * @return True si el punto está contiene del polígono o False si no lo está
     */
//    public bool puntoEnPoligono(Punto pt){
//        //NO HACER HASTA TEMA 4º
//        
//    }
}
