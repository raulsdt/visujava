/**
 * @Class VisuSegmento.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */

package visujava;

import java.awt.*;

public class VisuSegmento extends Vista {
    
    Segmento vs;
    /** Creates a new instance of VisuPunto */
    public VisuSegmento (Segmento s) {
        vs = s;
    }
    
    public void pinta (Graphics g){
        int alto  = ALTO;
        int ancho = ANCHO;
        /** convertir las distintas coordenadas a posiciones de pantalla */
        int sy = convCoordY(vs.leeby());
        int sx = convCoordX(vs.leebx());
        int iy = convCoordY(vs.leeay());
        int ix = convCoordX(vs.leeax());
        
        g.setColor(Color.RED);
        g.drawLine(ix,iy, sx,sy);
    
    }
    
}

