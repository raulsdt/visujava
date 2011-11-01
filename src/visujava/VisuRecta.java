/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;

import java.awt.*;
import visujava.*;
/**
 *
 * @author raul
 */
public class VisuRecta extends Vista{
    
    Recta r;
    
    public VisuRecta (Recta rs) {
        r = rs;
    }
    
    @Override
    public void pinta (Graphics g){
        int alto  = ALTO;
        int ancho = ANCHO;
        /** convertir las distintas coordenadas a posiciones de pantalla */
        int sy = convCoordY(r.leeB().leey()*Geometria.INFINITO);
        int sx = convCoordX(r.leeB().leex()*Geometria.INFINITO);
        int iy = convCoordY(r.leeA().leey()*Geometria.INFINITO);
        int ix = convCoordX(r.leeB().leex()*Geometria.INFINITO);
        
        g.setColor(Color.RED);
        g.drawLine(ix,iy, sx,sy);
    
    }
}
