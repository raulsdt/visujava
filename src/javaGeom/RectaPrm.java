package javaGeom;
import visujava.*;

import math.geom2d.line.StraightLine2D;
import math.geom2d.Point2D;

public class RectaPrm {
   StraightLine2D r;
    
   public RectaPrm (Vector v1, Vector v2){
       Point2D p1 = new Point2D (v1.leex(),v1.leey());
       Point2D p2 = new Point2D (v2.leex(),v2.leey());
       r = new StraightLine2D (p1,p2);
   }

   public RectaPrm (Punto p1, Punto p2){
       Point2D pp1 = new Point2D (p1.leex(),p1.leey());
       Point2D pp2 = new Point2D (p2.leex(),p2.leey());
       r = new StraightLine2D (pp1,pp2);
   }
    
   public Punto intersecta (RectaPrm r1){
       Point2D p = r.getIntersection(r1.r);
       Punto v = new Punto (p.getX(),p.getY());
       return v;
   }
}
