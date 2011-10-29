/******************************************************************************
Clase: Poligono.java
 ******************************************************************************/
package visujava;

import java.util.*;
import java.math.*;
import java.io.*;

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
        Vertice vertice = new Vertice();
        Random rnd = new Random(semilla);
            
        Vertices.add(new Vertice(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO), this, 1));
        Vertices.add(new Vertice(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO), this, 2));
        
        int i = 3;
        while(i < num){
            vertice = new Vertice(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO), this, i);
            if (vertice.izquierda(Vertices.get(i - 1), Vertices.get(i - 2))) {
                Vertices.add(vertice);
                i++;
            }
        }
        nVertices = num;
    }


    /**
     * Centroide del poligono
     * @return Punto centroide del poligono
     */
    public Punto centroide() {
        
    }

    /**
     * Área del poligono
     * @return Área
     */
    public double areaPoligono() {//Diviendo en triangulos
        Punto p = new Punto(0,0);
        double area = 0;
        
        for(int i = 0; i< nVertices; i++){
             area += p.areaTriangulo2(lee(i), lee(i+1)) / 2;
        }
        
        return area;
    }
    
    private boolean intersectaDiagonal(int i,int j){
        Segmento diagonal = new Segmento(lee(i),lee(j));
        
        for(int h = 0; h < nVertices; h++){
            if(diagonal.interseccion(new Segmento(lee(h),lee(h++)))){
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
        if(convexo()){
            if(lee((i-1)%nVertices).izquierda(lee(i%nVertices), lee(j%nVertices))
                    && lee((i+1)%nVertices).izquierda(lee(i%nVertices), lee(j%nVertices))){
                return intersectaDiagonal(i, j);
            }else{
                return false;
            }
        }else{ //Concavo
            if(!(lee((i+1)%nVertices).izquierdaSobre(lee(i%nVertices), lee(j%nVertices))
                    && lee((i-1)%nVertices).izquierdaSobre(lee(j%nVertices), lee(i%nVertices)))){
                return intersectaDiagonal(i, j);
            }else{
                return false;
            }
        }
    }
    
    private boolean tangente(Vertice v, Punto q){
        return q.izquierdaSobre(v.anterior(), v) ^ q.izquierdaSobre(v, v.siguiente());
    }

    /**
     * Dice si la recta que pasa por los dos vértices es tangente a los polígonos
     * @param v1 (this)
     * @param v2
     * @param p
     * @return True si es tangente o False si no lo es
     */
    public boolean tangenteEntrePoligonos(int posV1, int posV2, Poligono p) {  
        if(tangente(lee(posV1%nVertices), p.lee(posV2%p.nVertices))
                && tangente(p.lee(posV2%p.nVertices),lee(posV1%nVertices))){
            return true;
        }else{
            return false;
        }
    }

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
    public Poligono interseccionEntrePoligonos(Poligono p) {
        
    }
    /**
     * Determina si un punto está dentro del polígono
     * @param pt
     * @return True si el punto está dentro del polígono o False si no lo está
     */
//    public bool puntoDentroPoligono(Punto pt){
//        //NO HACER HASTA TEMA 4º
//        
//    }
}
