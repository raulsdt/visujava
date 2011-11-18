/**
 * @Class RayoPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;
import java.awt.geom.Point2D;
import math.geom2d.line.Ray2D;
import visujava.Punto;


public class RayoPrm {
    
    public Ray2D ry;
    
    /**
     * Cosntructor
     * @param o
     * @param p1 
     */
    public RayoPrm(Punto o,Punto p1){
        ry = new Ray2D(o.leex(), o.leey(), p1.leex(), p1.leey());
    }
    
    /**
     * Cosntructor
     * @param o
     * @param v1 
     */
    public RayoPrm(Punto o, Vector v1){
        ry = new Ray2D(o.leex(), o.leey(), v1.leex(), v1.leey());
    }
    
    /**
     * Determina si un Punto pertenece al rayo
     * @param p Punto 
     * @return True si el punto pertenece al rayo o False en caso contrario
     */
    public boolean contiene(Punto p){
        return ry.contains(p.leex(),p.leey());
    }
    
    /**
     * Determina la intersección entre rayo (this) - recta
     * @param r recta
     * @return El punto de intersección o null si no intersectan
     */
    public Punto intersecta(RectaPrm r){
        Point2D inter = ry.getIntersection(r.r);
        if(inter == null){
            return null;
        }
        return new Punto(inter.getX(),inter.getY());
    }
    
    /**
     * Determina la intersección entre rayo (this) - rayo
     * @param ry Rayo
     * @return El punto de intersección o null si no se intersectan
     */
    public Punto intersecta(RayoPrm rayo){
        Point2D inter =  ry.getIntersection(rayo.ry);
        if(inter == null){
            return null;
        }
        
        return new Punto(inter.getX(),inter.getY()); 
    }
    
    /**
     * Determina la distancia rayo - punto
     * @param p Punto
     * @return Distancia entre el rayo y el punto
     */
    public double distanciaPunto(Punto p){
        return ry.getDistance(p.leex(), p.leey());
    }
    
    /**
     * Escribe en pantalla (consola) un rayo
     */
    public void out(){
        String salida = ry.toString();
        System.out.println(salida);
    }
}
