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
        //Copiar uno a uno los puntos
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
    public ArrayList<Punto> ordenaXindice() {
    }

    /**
     * Ordena la nube de puntos de arriba a abajo
     */
    public void ordenaY() {
    }

    /**
     * Ordena la nube de puntos de arriba a abajo en otra nube
     * @return Nube de puntos ordenada de arriba a abajo
     */
    public NubePuntos ordenaYnube() {
    }

    /**
     * Ordenar la nube de puntos de arriba a abajo devolviendo las posiciones
     * @return Array de posiciones
     */
    public ArrayList<Punto> ordenaYindice() {
    }
}
