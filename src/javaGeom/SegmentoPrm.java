/**
 * @Class SegmentoPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;

import java.awt.Point;
import java.awt.geom.Point2D;
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
        Point2D p1 = new math.geom2d.Point2D(o.leex(), o.leey());
        Point2D p2 = new math.geom2d.Point2D(d.leex(), d.leey());
         s = new LineSegment2D(p1, p2);
        
    }
    
    /**
     * Constructor de segmento dado cuatro coordenadas de dos puntos
     * @param ox
     * @param oy
     * @param dx
     * @param dy 
     */
    public SegmentoPrm(double ox,double oy,double dx,double dy){
        Point2D p1 = new math.geom2d.Point2D(ox, oy);
        Point2D p2 = new math.geom2d.Point2D(dx, dy);
         s = new LineSegment2D(p1, p2);
    }
    
    /**
     * Determina si un punto pertenece al segmento
     * @param p Punto
     * @return True si el Segmento contiene el punto o Fasle en caso contrario
     */
    public boolean contiene(Punto p){
        //IMPLEMENTAR
        Point2D p1 = new math.geom2d.Point2D(p.leex(), p.leey());
       return s.contains(p1);
    }
    
    /**
     * Determina la intersección de segmento (this) - Recta
     * @param r Recta
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(RectaPrm r){
        if(s.getIntersection(r.r)==null) return null;
        Point2D p = new math.geom2d.Point2D(s.getIntersection(r.r));
        return (new Punto(p.getX(), p.getY()));
    }
    
    /**
     * Determina la intersección de segmento (this) - Rayo
     * @param ry Rayo
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(RayoPrm ry){

        if(s.getIntersection(ry.ry)==null) return null;
        Point2D p = new math.geom2d.Point2D(s.getIntersection(ry.ry));
        return (new Punto(p.getX(), p.getY()));
    }
    
    /**
     * Determina la intersección de segmento (this) - Segmento
     * @param s Segmento
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(SegmentoPrm r){
        if(s.getIntersection(r.s) ==null) return null;
        Point2D p = s.getIntersection(r.s);

        return (new Punto(p.getX(), p.getY()));
        

    }
    
    /**
     * distancia entre segmento (this) - punto
     * @param p Punto
     * @return La distancia entre el segmento y el punto
     */
    public double distanciaPunto(Punto p){
        Point2D p1 = new math.geom2d.Point2D(p.leex(), p.leey());
       return  s.getDistance(p1);
        
    }
    
    public void out(){
        String salida = s.toString();
        System.out.println(salida);
    }
    
}
