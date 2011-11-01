/*
 * CApplet.java
 *
 * Created on 14 de octubre de 2006, 13:05
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package visujava;

/**
 *
 * @author lidia
 */


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Vector;

/**
 *
 * @author lidia
 */

public class CApplet extends java.applet.Applet {

  public void init(Graphics g) {
       
  }
 
  /**pinta el eje de coordenadas en pantalla */ 
  private void ejesCoordenadas (Graphics g) throws Exception{
        g.setColor(Color.white);
        int ancho = Vista.ANCHO;
        int alto = Vista.ALTO;
        g.drawRect(0,0, ancho,alto);
        g.fillRect(0,0, ancho,alto);
        g.setColor(Color.gray);
        g.drawLine((int)(ancho/2) , 0, (int)(ancho/2), alto); //línea vertical
        g.drawLine(0,(int)alto/2,ancho,(int)alto/2); //linea horizontal

        int medx = (int)(ancho/2); 
        int medy = (int)(alto/2);
        
        int x = medx;
        while (x<ancho){
           g.drawLine(x , medy-2, x, medy+2);         
           g.drawLine(ancho-x,medy-2,ancho-x,medy+2);
           x += (int )(ancho * 10) / (2*Geometria.RANGO);
        }
        int y = medy;
        while (y<alto){
           g.drawLine(medx-2, y , medx+2, y);         
           g.drawLine(medx-2,alto-y,medx+2,alto-y);
           y += (int )(alto * 10) / (2*Geometria.RANGO);
        }
       
  } 
  
  
  /** Modificar: meter aquí el código de prueba */
  private void pintar(Graphics g) throws Exception {
            
      VisuPunto p = new VisuPunto(new Punto(0,40));
      VisuSegmento s = new VisuSegmento(new Segmento(new Punto(4,4),new Punto(40,40)));
      
      Poligono pol = new Poligono();
      pol.anade(new Vertice(0, 0, pol));
      pol.anade(new Vertice(50, 0, pol));
      pol.anade(new Vertice(50, 50, pol));
      pol.anade(new Vertice(0, 50, pol));
      VisuPoligono vpol = new VisuPoligono(pol);
      
      /** Definimos un array polimorfo */
      Vista vv[] = new Vista[3];
      vv[0] = p;
      vv[1] = s;
      vv[2] = vpol;
            
      
      for (int i = 0; i<3; i++){
          Vista obj = vv[i]; //enganche polimorfo
          obj.pinta(g);     //ligadura dinámica
      }
      
 
  }
  
    public void paint( Graphics g ) {
    try {
      Rectangle r = g.getClipBounds();
      Vista.ALTO  = (int)r.getHeight();
      Vista.ANCHO = (int)r.getWidth();  
      ejesCoordenadas(g);  
      pintar(g);
    }
    catch (Exception e) {
    e.printStackTrace();
    }
   }

}

