/**
 * @Class VisuNube.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;

import java.awt.*;
import java.util.ArrayList;


public class VisuNube extends Vista{
    /**Lista de puntos*/
    ArrayList<Punto> nube;
    
    /** Creates a new instance of VisuNube */
    public VisuNube(NubePuntos n) {
        nube = (ArrayList<Punto>) n.nube.clone();
    }
    
    
    /**
     * Metodo que grafiaca en pantalla la nube de puntos
     * @param g Es el canvas donde se pinta la nube de puntos
     */
    public void pinta (Graphics g){
        VisuPunto vp;
        for(int i = 0; i < nube.size(); i++){
            vp = new VisuPunto(nube.get(i));
            vp.pinta(g);
            
            //Pintamos los números asociados a cada punto de la nube
            int xp = convCoordX(nube.get(i).leex());
            int yp = convCoordY(nube.get(i).leey());
            
            int tama = ANCHO_PUNTO;
            
            g.drawString(Integer.toString(i),(int)xp-(int)(tama/2),(int)yp-(int)(tama/2));
        }
    }
}
