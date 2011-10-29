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

        //Introducimos los vertices en sentido antihorario
        if (Vertices.get(0).leex() > Vertices.get(1).leex()) {
            vertice = new Vertice(Vertices.get(0).leex(), Vertices.get(0).leey(), this, 2);
            Vertices.set(0, Vertices.get(1));
            Vertices.get(0).modificaPosicion(1);//Modificamos las posiciones
            Vertices.set(num, vertice);
        }

        for (int i = 3; i <= num; i++) {//Los dos primeros se introducen a pelo
            do {
                vertice = new Vertice(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO), this, i);
                if (vertice.izquierda(Vertices.get(i - 2), Vertices.get(i - 1))) {
                    Vertices.add(vertice);
                }
            } while (!vertice.izquierda(Vertices.get(i - 2), Vertices.get(i - 1)));
        }
    }

    /**
     * @see Calcula el baricentro o centroide ce un triangulo
     * @param v1 Vertice 1
     * @param v2 Vertice 2
     * @param v3 Vertice 3
     * @return Punto baricentro del triangulo
     */
    private Punto baricentroTriangulo(Punto v1, Punto v2, Punto v3) {
        return new Punto((v1.x + v2.x + v3.x) / 3, (v1.y + v2.y + v3.y) / 3);
    }

    /**
     * Centroide del poligono
     * @return Punto centroide del poligono
     */
    public Punto centroide() { //Para ello hay que dividir el poligono en triangulos
        ArrayList<Punto> Centroides = new ArrayList<Punto>();
        ArrayList<Punto> Centroides2 = new ArrayList<Punto>();
        if (convexo()) {

            Centroides.add(baricentroTriangulo(Vertices.get(0), Vertices.get(1), Vertices.get(2)));

            for (int i = 2; i < Vertices.size() - 1; i++) {
                Centroides.add(baricentroTriangulo(Vertices.get(0), Vertices.get(i), Vertices.get(i + 1)));
            }

            while (Centroides.size() > 3) {
                Centroides2.clear();
                Centroides2 = new ArrayList<Punto>(Centroides);
                Centroides.clear();
                Centroides.add(baricentroTriangulo(Centroides2.get(0), Centroides2.get(1), Centroides2.get(2)));
                for (int i = 2; i < Centroides2.size() - 1; i++) {
                    Centroides.add(baricentroTriangulo(Centroides2.get(0), Centroides2.get(i), Centroides2.get(i + 1)));
                }
            }

            if (Centroides.size() == 3) {
                return baricentroTriangulo(Centroides.get(0), Centroides.get(1), Centroides.get(2));
            } else {
                return new Segmento(Centroides.get(0), Centroides.get(1)).PuntoMedio();
            }
        } else {
        }
    }

    /**
     * Área del poligono
     * @return Área
     */
    public double areaPoligono() {//Diviendo en triangulos
        //RAUL
    }

    /**
     * Diagonal interna dadas dos posiciones (vertices)
     * @param a Número del vértice
     * @param b Número del vértice
     * @return True si es diagonal interna o False si no lo es
     */
    public bool diagonalInterna(int a, int b) {
        //RAUL
    }

    /**
     * Dice si la recta que pasa por los dos vértices es tangente a los polígonos
     * @param v1
     * @param v2
     * @param p
     * @return True si es tangente o False si no lo es
     */
    public bool tangenteEntrPoligonos(Vertice v1, Vertice v2, Poligono p) {
        //JOSE
    }

    /**
     * Polígono convexo
     * @return True si el polígono es convexo o False si no lo es
     */
    public boolean convexo() {
        boolean convexo = true;
        for (int i = 0; i < Vertices.size(); i++) {
            if (!Vertices.get(i).convexo()) {
                convexo = false;
            }
        }
        return convexo;
    }

    /**
     * Intersección entre poligonos convexos
     * @param p
     * @return El poligono intersección de los dos polígonos
     */
    public Poligono interseccionEntrePoligonos(Poligono p) {
        //JOSE
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
