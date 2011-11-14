package javaGeom;
import visujava.*;

import math.geom2d.line.StraightLine2D;
import math.geom2d.Point2D;

public class RectaPrm {
   StraightLine2D r;
   
   /**
    * Constructor 
    * @param v1
    * @param v2 
    */
   public RectaPrm (Vector v1, Vector v2){
       Point2D p1 = new Point2D (v1.leex(),v1.leey());
       Point2D p2 = new Point2D (v2.leex(),v2.leey());
       r = new StraightLine2D (p1,p2);
   }
   
   /**
    * Constructor
    * @param p1
    * @param p2 
    */
   public RectaPrm (Punto p1, Punto p2){
       Point2D pp1 = new Point2D (p1.leex(),p1.leey());
       Point2D pp2 = new Point2D (p2.leex(),p2.leey());
       r = new StraightLine2D (pp1,pp2);
   }
    
   /**
    * Constructor
    * @param r1
    * @return 
    */
   public Punto intersecta (RectaPrm r1){
       Point2D p = r.getIntersection(r1.r);
       Punto v = new Punto (p.getX(),p.getY());
       return v;
   }
   
   //-------------------- OPERACIONES
   
   /**
    * Dice si un punto está contenido en la recta
    * @param p
    * @return 
    */
   public boolean contiene(Punto p){
       return r.contains(p.leex(), p.leey());
   }
   
   /**
    * Recta paralela a una distancia dada de la recta this
    * @param x
    * @return 
    */
   public RectaPrm paralelaDistancia(float x){
       //IMPLEMENTAR
       return null;
   }
   
   /**
    * Calcular una nueva recta perpendicular a this en un punto
    */
   public RectaPrm perpendicularPunto(Punto p){
       //IMPLEMENTAR
       return null;
   }
   
   /**
    * Calcula la distancia de la recta (this) al punto
    */
   public double distanciaPunto(Punto p){
       //IMPLEMENTAR
       return 0;
   }
   
   /**
    * Escribe en pantalla una recta
    */
   public void out(){
       
   }
   
}
