/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;

import java.awt.*;


public class VisuRayo extends Vista{
    /**Rayo que se desea dibujar*/
    Rayo r;
    
    /**
     * Constructor de la Clase Rayo
     * @param ry Rayo que se desea dibujaar
     */
    public VisuRayo(Rayo ry) {
        r = ry;
    }
    
    /**
     * Metodo que permite dibujar en pantalla el rayo
     * @param g Clase que permite graficar en pantalla
     */
    @Override
    public void pinta (Graphics g){
        int alto  = ALTO;
        int ancho = ANCHO;
        int sy,sx,iy,ix;

        /*Realizamos los cortes de la recta con los bordes de la pantalla
         y cogemos los puntos de corte*/
        
        /*RECORDAR: (RANGO * 2) es el ancho y alto de la pantalla */
        
        Punto pDirec;
        
        Recta horizontalSup = new Recta(-20, Geometria.RANGO * 2, 20, Geometria.RANGO * 2);
        Recta horizontalInf = new Recta(-20, Geometria.RANGO * (-2), 20, Geometria.RANGO * (-2));
        
        /*Tenemos que ver la orientación del rayo para dibujarlo
        para ello usamos el metodo cuadrante de la clase Punto*/
        /*RECORDAR que el punto A es el ORIGEN y B nos indica la dirección*/
        
        int cuadrante = r.leeA().cuadrante(r.leeB());
        
        if(new Segmento(r.leeA(), r.leeB()).esHorizontal()){ //Si es horizontal lo tratamos con las rectas verticales
            Recta verticalIzq = new Recta(Geometria.RANGO * (-2),10,Geometria.RANGO * (-2),20);
            Recta verticalDer = new Recta(Geometria.RANGO * 2, 10, Geometria.RANGO * 2,20);
            
            if(( r.leeB().leex() - r.leeA().leex() ) > Geometria.CERO){
                //El rayo está hacia la derecha
                pDirec = r.intersecta(verticalDer);
            }else{
                //El rayo está hacia la izquierda
                pDirec = r.intersecta(verticalIzq);
            }
        }else{
            if(cuadrante == 1 || cuadrante == 2){ //Orientación hacia arriba(Corte con horizontalSup)
                pDirec= r.intersecta(horizontalSup);
            }else{ //Orientación hacia arriba(Corte con horizontalInf)
                pDirec = r.intersecta(horizontalInf);
            }
        }
               
        sy = convCoordY(pDirec.leey());
        sx = convCoordX(pDirec.leex());
        iy = convCoordY(r.leeA().leey());
        ix = convCoordX(r.leeA().leex());
        
        g.setColor(Color.ORANGE); //Color de los rayos --> NARANJA
        g.drawLine(ix,iy, sx,sy);
    
    }
}
