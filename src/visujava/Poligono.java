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
    protected Vector Vertices;
    
    /** Contruye un Poligono por defecto (sin ningun Vertice). */
    public Poligono () {
        Vertices = new Vector ();
        nVertices = 0;
    }
    
    /** Construye un Poligono con un numero de Vertices nV. */
    public Poligono (int nV) {
        Vertices = new Vector (nV);
        nVertices = nV;
    }
    
    /** Construye un Poligono como p1. Para ello se utiliza el metodo clone,
     sin necesidad de reservar memoria, ya que para usar este metodo no es
     necesario. */
    public Poligono(Poligono pl) {
        Vertices = (Vector) pl.Vertices.clone ();
        nVertices = pl.nVertices;
    }
    
    /** Construye un Poligono con el numero de Vertice nV, los cuales estaran
     en el vector vert. */
    public Poligono (Vector vert, int nV) {
        Vertices = (Vector) vert.clone();
        nVertices = nV;
    }
    
    /** Devuelve una copia del Poligono actual. */
    public Poligono copia () {
        Poligono nuevoPoligono = new Poligono (nVertices);
        nuevoPoligono.Vertices = (Vector) Vertices.clone ();
        nuevoPoligono.nVertices = nVertices;
        return nuevoPoligono;
    }
    
    /** Obtiene una copia del Poligono pl. */
    public void copia (Poligono pl) {
        Vertices.clear();                           //Se limpia el vector.
        Vertices = (Vector) pl.Vertices.clone();    //Se copia el vector.
        nVertices = pl.nVertices;
    }
    
    /** Establece el Vertice v en la posicion pos del Poligono actual. Teniendo
     en cuenta que el vector esta indexado desde 0. */
    public void modifica (Vertice v,int pos) {
        if (pos >= 0 && pos < nVertices) {
            Vertice antiguo = new Vertice ((Vertice) Vertices.get (pos));
            antiguo.modificaPoligono (null);
            antiguo.modificaPosicion (-1);
            Vertices.set(pos, (Vertice)v);
            v.modificaPoligono (this);
            v.modificaPosicion (pos);
        }
    }
    
    /** Establece el v�rtice v en la �ltima posici�n del pol�gono actual. */
    public void anade (Vertice v) {
        Vertices.add ((Vertice)v);
        v.modificaPoligono (this);
        v.modificaPosicion (nVertices);
        nVertices ++;
    }
    
    /** Devuelve el v�rtice v que ocupa la posici�n pos. */
    public Vertice lee (int pos) {
        if (pos >= 0 && pos < nVertices)
            return (Vertice) Vertices.get (pos);
        else
            return null;
    }
    
    
    /** Devuelve una copia del v�rtice v que ocupa la posici�n pos. */
    public Vertice leeAsigna (int pos) {
        if (pos >= 0 && pos < nVertices)
            return new Vertice ((Vertice) Vertices.get(pos));
        else
            return null;
    }
    
    /** Devuelve el n�mero de v�rtices que tiene el pol�gono. */
    public int numeroVertices () {
        return nVertices;
    }
    
    
    /** Muestra por pantalla la informaci�n del pol�gono. */
    public void out () {
        Vertice v = new Vertice ();
        for (int i = 0;i < nVertices;i++) {
            v = (Vertice)Vertices.get(i);
            v.out ();
        }
    }
    
    /******************** METODOS PROPIOS *******************/
    
    /**
     * Contructor que construye en poligono aleatorio
     * @param num Número de vértices
     * @param semilla Semilla de aleatoriedad
     */
    public Poligono(int num,float semilla){
        
    }
    
    /**
     * Centroide del poligono
     * @return Punto centroide del poligono
     */
    public Punto centroide(){
        
    } 
    
    /**
     * Área del poligono
     * @return Área
     */
    public double areaPoligono(){
        
    }
    
    /**
     * Diagonal interna dadas dos posiciones (vertices)
     * @param a Número del vértice
     * @param b Número del vértice
     * @return True si es diagonal interna o False si no lo es
     */
    public bool diagonalInterna(int a,int b){
        
    }
    
    /**
     * Dice si la recta que pasa por los dos vértices es tangente a los polígonos
     * @param v1
     * @param v2
     * @param p
     * @return True si es tangente o False si no lo es
     */
    public bool tangenteEntrPoligonos(Vertice v1, Vertice v2, Poligono p){
        
    }
    
    /**
     * Polígono convexo
     * @return True si el polígono es convexo o False si no lo es
     */
    public bool conveso(){
        //Es conveso si todos sus vértices lo son
    }
    
    /**
     * Intersección entre poligonos convexos
     * @param p
     * @return El poligono intersección de los dos polígonos
     */
    public Poligono interseccionEntrePoligonos(Poligono p){
        
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
