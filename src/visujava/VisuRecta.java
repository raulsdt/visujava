/**
 * @Class VisuRecta.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;

import java.awt.*;

public class VisuRecta extends Vista{
    
    Recta r;
    
    public VisuRecta (Recta rs) {
        r = rs;
    }
    
    @Override
    public void pinta (Graphics g){
        int alto  = ALTO;
        int ancho = ANCHO;
        int sy,sx,iy,ix;

        /*Realizamos los cortes de la recta con los bordes de la pantalla
         y cogemo slos puntos de corte*/
        
        /*RECORDAR: (RANGO * 2) es el ancho y alto de la pantalla */
        
        Punto pSup,pInf;
        
        if(new Segmento(r.leeA(),r.leeB()).esHorizontal()){ //Si es horizontal lo tratamos con las rectas verticales
            Recta verticalIzq = new Recta(Geometria.RANGO * (-2),10,Geometria.RANGO * (-2),20);
            Recta verticalDer = new Recta(Geometria.RANGO * 2, 10, Geometria.RANGO * 2,20);
            pSup = r.intersecta(verticalIzq);
            pInf = r.intersecta(verticalDer);
        }else{
            Recta horizontalSup = new Recta(-20, Geometria.RANGO * 2, 20, Geometria.RANGO * 2);
            Recta horizontalInf = new Recta(-20, Geometria.RANGO * (-2), 20, Geometria.RANGO * (-2));
            pSup = r.intersecta(horizontalSup);
            pInf = r.intersecta(horizontalInf);
        }
        
        sy = convCoordY(pSup.leey());
        sx = convCoordX(pSup.leex());
        iy = convCoordY(pInf.leey());
        ix = convCoordX(pInf.leex());
        
        g.setColor(Color.RED);
        g.drawLine(ix,iy, sx,sy);
    
    }
}
