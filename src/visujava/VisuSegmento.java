/*
 * VisuSegmento.java
 *
 * Created on 11 de octubre de 2006, 20:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package visujava;

import java.awt.*;
import visujava.*;

/**
 *
 * @author lidia
 */
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

