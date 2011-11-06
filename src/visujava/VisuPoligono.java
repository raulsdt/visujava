/**
 * @Class VisuPoligono.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;

import java.awt.*;

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


