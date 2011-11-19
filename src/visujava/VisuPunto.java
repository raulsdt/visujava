/**
 * @Class VisuPunto.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;
import java.awt.*;

public class VisuPunto extends Vista {
    
    Punto vp;
    /** Creates a new instance of VisuPunto */
    public VisuPunto (Punto p) {
        vp = p;
    }
    
    public Punto getPunto (){
        return vp;
    }
    
    public void pinta (Graphics g){
 
        int xp = convCoordX(vp.leex());
        /** convierte la y en posiciones de pantalla */
        //int yp = (int)(alto-((vp.leey()*alto)/(2*Geometria.RANGO)+(alto/2))); 
        int yp = convCoordY(vp.leey());
        /** pasar a coordenadas de pantalla */
        int tama = ANCHO_PUNTO;
        g.setColor(Color.BLUE);
        g.fillOval((int)xp-(int)(tama/2),(int)yp-(int)(tama/2),tama,tama);
    }
    
}
