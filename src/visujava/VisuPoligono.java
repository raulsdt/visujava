/*
 * VisuPoligono.java
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
public class VisuPoligono extends Vista {
    
    Poligono vp;
    /** Creates a new instance of VisuPunto */
    public VisuPoligono (Poligono p) {
        vp = p;
    }
    
    public void pinta (Graphics g){
        int alto  = ALTO;
        int ancho = ANCHO;
        /** convertir las distintas coordenadas a posiciones de pantalla */
        int tama = vp.numeroVertices();
        g.setColor(Color.GREEN);
        for (int i = 0; i<tama; i++){
           int sy = convCoordY(vp.lee(i).leey());
           int sx = convCoordX(vp.lee(i).leex());
           int imas1 = (i+1)%tama;
           int iy = convCoordY(vp.lee(imas1).leey());
           int ix = convCoordX(vp.lee(imas1).leex());
           g.drawLine(ix,iy, sx,sy);
        }
    }
    
}


