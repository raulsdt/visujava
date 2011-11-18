/**
 * @Class VisuSegmentoPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;
import visujava.Segmento;
import visujava.VisuSegmento;


public class VisuSegmentoPrm extends VisuSegmento{
    public VisuSegmentoPrm(SegmentoPrm seg){
        //El parámentro t pertenece [0,1]
        super(new Segmento(seg.s.getPoint(0).getX(),seg.s.getPoint(0).getY(),seg.s.getPoint(1).getX(),seg.s.getPoint(1).getY()));
    }
}
