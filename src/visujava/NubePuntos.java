/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;

import java.util.*;
import java.math.*;

/**
 *
 * @author serrano
 */
public class NubePuntos {

    protected int num;
    protected ArrayList<Punto> nube;

    /**
     * Construye una pube de punto aleatoria
     * @param n
     */
    public NubePuntos(int n, int semilla) {
        Random rnd = new Random(semilla);

        for (int i = 0; i < n; i++) {
            nube.add(new Punto(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO)));
        }
        num = n;

    }
    
    public NubePuntos(NubePuntos n){
        
        for(int i=0;i<n.num;i++){
            nube.add(n.getPunto(i));
        }
        
    }
    
    /**
     * Construye una pube de puntos desde un fichero
     * @param rutaFichero 
     */
    public NubePuntos(String rutaFichero) {
    }

    /**
     * Guarda un polígono en un fichero
     * @param p
     * @param ruta 
     */
    public void salvar(Poligono p, String ruta) {
    }

    /**
     * Punto dada una posición
     * @param Posicion del punto iniciando en cero
     * @return Punto de la posición dada
     */
    public Punto getPunto(int pos) {
        if (pos < num - 1 && pos >= 0) {
            return nube.get(pos);
        }
        return null;
    }

    /**
     * Caja que envuelve a toda la nube de puntos
     * @return Los punto que forman la caja envolvente
     */
    public Poligono cajaEnvolvente() {
        NubePuntos nubeX = new NubePuntos(ordenaXnube());
        NubePuntos nubeY = new NubePuntos(ordenaYnube());
        ArrayList<Vertice> Vertices = new ArrayList<Vertice>();
        
        //Metemos los vertices del cuadrilatero en sentido antihorario
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(0).leex(), nubeY.getPunto(0).leey())));
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(0).leex(), nubeY.getPunto(num-1).leey())));
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(num-1).leex(), nubeY.getPunto(num-1).leey())));
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(num-1).leex(), nubeY.getPunto(0).leey())));
        
        return new Poligono(Vertices, 4);
    }

    /**
     * Punto central de la nube
     * @return 
     */
    public Punto puntoCentral() {
        double sumX=0,sumY=0;
        for(int i=0;i<num;i++){
            sumX += nube.get(i).leex();
            sumY += nube.get(i).leey();
        }
        return new Punto(sumX/num, sumY/num);
    }

    public Punto puntoCentroide() {
        
    }

    /**
     * Ordena la nube de puntos de izquierda a derecha
     */
    public void ordenaX() {
        Collections.sort(nube, new ComparadorIzqDer());
    }

    /**
     * Ordena la nube de puntos de izquierda a derecha en otra nube
     * @return Nube de puntos ordenada de izquierda a derecha
     */
    public NubePuntos ordenaXnube() {
        NubePuntos n = new NubePuntos(this);
        
        Collections.sort(n.nube, new ComparadorIzqDer());
        
        return n;
    }

    /**
     * Ordenar la nube de puntos de izquierda a derecha devolviendo las posiciones
     * @return Array de posiciones
     */
    public ArrayList<Integer> ordenaXindice() {
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        NubePuntos nubelo = new NubePuntos(ordenaXnube());
        
        for(int i=0;i< nubelo.num;i++){
            posiciones.add(nube.indexOf(nubelo.getPunto(i)));
        }
        return posiciones;
    }

    /**
     * Ordena la nube de puntos de arriba a abajo
     */
    public void ordenaY() {
        Collections.sort(nube, new ComparadorArrAbaj());
    }

    /**
     * Ordena la nube de puntos de arriba a abajo en otra nube
     * @return Nube de puntos ordenada de arriba a abajo
     */
    public NubePuntos ordenaYnube() {
        NubePuntos n = new NubePuntos(this);
        
        Collections.sort(nube, new ComparadorArrAbaj());
        
        return n;
    }

    /**
     * Ordenar la nube de puntos de arriba a abajo devolviendo las posiciones
     * @return Array de posiciones
     */
    public ArrayList<Integer> ordenaYindice() {
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        NubePuntos nubelo = new NubePuntos(ordenaYnube());
        
        for(int i=0;i< nubelo.num;i++){
            posiciones.add(nube.indexOf(nubelo.getPunto(i)));
        }
        return posiciones;
    }
}
