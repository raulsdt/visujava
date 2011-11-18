/**
 * @Class VisuRectaPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;

import java.awt.*;
import math.geom2d.Box2D;
import math.geom2d.Point2D;
import math.geom2d.line.StraightLine2D;
import visujava.Vista;


public class VisuRectaPrm extends Vista {
    
    RectaPrm rp;
    /** Creates a new instance of VisuPunto */
    public VisuRectaPrm (RectaPrm  r) {
        rp = r;
    }
    
    public RectaPrm getRectaPrm (){
        return rp;
    }
    
        
    @Override 
    public void pinta (Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Box2D box = new Box2D(0, ANCHO, 0, ALTO);
        
        Point2D p1 = new Point2D (rp.r.getOrigin());
        Point2D p2 = new Point2D (rp.r.getPoint(5));
        
        int p1x = convCoordX(p1.getX());
        int p1y = convCoordY(p1.getY());    
        int p2x = convCoordX(p2.getX());
        int p2y = convCoordY(p2.getY());
        Point2D pp1 = new Point2D (p1x,p1y);
        Point2D pp2 = new Point2D (p2x,p2y);
        
        StraightLine2D sl = new StraightLine2D (pp1,pp2); 
        sl.clip(box).draw(g2);
        
        p1.draw(g2);
        p2.draw(g2);
    }    
    
}
