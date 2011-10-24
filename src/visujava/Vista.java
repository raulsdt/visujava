/*
 * vista.java
 *
 * Created on 11 de octubre de 2006, 20:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package visujava;

import java.awt.*;

/**
 *
 * @author lidia
 */
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
