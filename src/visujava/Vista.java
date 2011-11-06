/**
 * @Class Vista.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */

package visujava;

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
