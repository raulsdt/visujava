/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGeom;
import visujava.Geometria;

/**
 *
 * @author lidia
 */

import java.awt.*;

public abstract class Vista {
   
  static int ANCHO , ALTO,  ANCHO_PUNTO=6;
  
  public int convCoordX (double x) {
      return ((int)(x*ANCHO)/(2*Geometria.RANGO)+(ANCHO/2)); 
  }
  
  public int convCoordY (double y) {
      return ((int)(ALTO-((y*ALTO)/(2*Geometria.RANGO)+(ALTO/2)))); 
  }
    
    /** primitiva abstracta */
    
    public abstract void pinta(Graphics g);
}
