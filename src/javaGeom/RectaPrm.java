/**
 * @Class RectaPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;
import visujava.*;

import math.geom2d.line.StraightLine2D;
import math.geom2d.Point2D;

public class RectaPrm {
   StraightLine2D r;
   
   /**
    * Constructor de la recta dados dos vectores
    * @param v1 Vector de la recta
    * @param v2 Vector de la recta
    */
   public RectaPrm (Vector v1, Vector v2){
       Point2D p1 = new Point2D (v1.leex(),v1.leey());
       Point2D p2 = new Point2D (v2.leex(),v2.leey());
       r = new StraightLine2D (p1,p2);
   }
   
   
   /**
    * Constructor de la recta dados dos puntos de la recta
    * @param p1 Punto de la recta
    * @param p2 Punto de la recta
    */
   public RectaPrm (Punto p1, Punto p2){
       Point2D pp1 = new Point2D (p1.leex(),p1.leey());
       Point2D pp2 = new Point2D (p2.leex(),p2.leey());
       r = new StraightLine2D (pp1,pp2);
   }
    
   /**
    * Intersección entre rectas
    * @param r1 Recta
    * @return El punto de intersección si se intersectan o null en caso contrario
    */
   public Punto intersecta (RectaPrm r1){
       Point2D p = r.getIntersection(r1.r);
       
       if(p == null){
           return null; //No hay intersección, rectas paralelas
       }
       
       Punto v = new Punto (p.getX(),p.getY());
       return v;
   }
   
   //-------------------- OPERACIONES
   
   /**
    * Dice si un punto está contenido en la recta
    * @param p Punto
    * @return True si el punto está contenido en la recta, o False en caso contrario
    */
   public boolean contiene(Punto p){
       return r.contains(p.leex(), p.leey());
   }
   
   /**
    * Recta paralela a una distancia dada de la recta (this)
    * @param x distancia de la recta paralera respecto a la recta(this)
    * @return La recta paralela a una distancia determinada
    */
   public RectaPrm paralelaDistancia(float x){
       StraightLine2D paralela = r.getParallel(x);
       //Extraemos dos puntos de la recta, como parametro 1 y 10 (puede ser cualquiera)
       Point2D p1 = paralela.getPoint(1);
       Point2D p2 = paralela.getPoint(10);
       
       return new RectaPrm(new Punto(p1.getX(), p1.getY()),new Punto(p2.getX(),p2.getY()));
   }
   
   /**
    * Calcular una nueva recta perpendicular a this en un punto
    * @param p Punto perteneciente a la recta (this)
    * @return Recta perpendicular que pasa por un determinado punto
    */
   public RectaPrm perpendicularPunto(Punto p){
       StraightLine2D perpendicular = r.getPerpendicular(new Point2D(p.leex(), p.leey()));
       //Extraemos dos puntos de la recta, como parametro 1 y 10 (puede ser cualquiera)
       Point2D p1 = perpendicular.getPoint(1);
       Point2D p2 = perpendicular.getPoint(10);
       
       return new RectaPrm(new Punto(p1.getX(), p1.getY()),new Punto(p2.getX(),p2.getY()));
   }
   
   /**
    * Calcula la distancia de la recta (this) al punto
    * @param p Punto
    * @return La distancia del punto a la recta
    */
   public double distanciaPunto(Punto p){
       return r.getDistance(p.leex(), p.leey());
   }
   
   /**
    * Escribe en pantalla una recta
    */
   public void out(){
       String salida = r.toString();
       System.out.println(salida);
   }
   
}
