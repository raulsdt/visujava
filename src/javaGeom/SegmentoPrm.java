/**
 * @Class SegmentoPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;

import math.geom2d.line.LineSegment2D;
import visujava.Punto;

public class SegmentoPrm {
    
    LineSegment2D s;
    
    /**
     * Constructor de segmento dados dos puntos
     * @param o
     * @param d 
     */
    public SegmentoPrm(Punto o,Punto d){
        
    }
    
    /**
     * Constructor de segmento dado cuatro coordenadas de dos puntos
     * @param ox
     * @param oy
     * @param dx
     * @param dy 
     */
    public SegmentoPrm(double ox,double oy,double dx,double dy){
        
    }
    
    /**
     * Determina si un punto pertenece al segmento
     * @param p Punto
     * @return True si el Segmento contiene el punto o Fasle en caso contrario
     */
    public boolean contiene(Punto p){
        //IMPLEMENTAR
        return true;
    }
    
    /**
     * Determina la intersección de segmento (this) - Recta
     * @param r Recta
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(RectaPrm r){
        //IMPLEMENTAR
        return null;
    }
    
    /**
     * Determina la intersección de segmento (this) - Rayo
     * @param ry Rayo
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(RayoPrm ry){
        //IMPLEMENTAR
        return null;
    }
    
    /**
     * Determina la intersección de segmento (this) - Segmento
     * @param s Segmento
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(SegmentoPrm s){
        //IMPLEMENTAR
        return null;
    }
    
    /**
     * distancia entre segmento (this) - punto
     * @param p Punto
     * @return La distancia entre el segmento y el punto
     */
    public double distanciaPunto(Punto p){
        //IMPLEMENTAR
        return 0;
    }
    
    public void out(){
        String salida = s.toString();
        System.out.println(salida);
    }
    
}
