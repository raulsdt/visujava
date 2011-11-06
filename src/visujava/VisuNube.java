/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author serrano
 */
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
        }
    }
}
