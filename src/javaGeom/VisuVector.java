/**
 * @Class VisuVector.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 5-12-2011
 */

package javaGeom;

import visujava.Punto;
import visujava.VisuPunto;

//Heredemoa de Visupunto y adaptamos con el constructor
public class VisuVector extends VisuPunto{
    
    public VisuVector(Vector v) {
        super(new Punto(v.leex(),v.leey()));
    }
    
}
