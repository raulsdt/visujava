/**
 * @Class VisuRayoPrm.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;
import visujava.Rayo;
import visujava.VisuRayo;

//Heredamos de la clase Visual de Rayo y la adaptamos con el constructor
public class VisuRayoPrm extends VisuRayo{

    public VisuRayoPrm(RayoPrm rayo){
        //El parámentro t pertenece [0,+INF)
        super(new Rayo(rayo.ry.getFirstPoint().getX(),rayo.ry.getFirstPoint().getY(), rayo.ry.getPoint(1).getX(), rayo.ry.getPoint(1).getY()));
    }
    
}
