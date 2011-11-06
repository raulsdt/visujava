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
import java.util.ArrayList;

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
     /*PROBANDO POLIGONO*/       
//      Poligono poli = new Poligono(4, 80);
//      VisuPoligono vpoli = new VisuPoligono(poli);
      
      //PROBANDO NUBE-PUNTOS
       Poligono poli = new Poligono(5, 80);
      VisuPoligono vpoli = new VisuPoligono(poli);
      Poligono poli2 = new Poligono();
      
      Vertice v1 = new Vertice(-20, 10, poli2,0);
      Vertice v2 = new Vertice(50, 40, poli2,1);
      Vertice v3 = new Vertice(50, 60, poli2,2);
      Vertice v4 = new Vertice(-50, 60, poli2,3);
      Vertice v5 = new Vertice(-30, 20, poli2,4);
      poli2.anade(v1);
      poli2.anade(v2);
      poli2.anade(v3);
      poli2.anade(v4);
      poli2.anade(v5);
      
      VisuPoligono vpoli2 = new VisuPoligono(poli2);
      
      Poligono poliIntersecta = new Poligono();
      poliIntersecta = poli.intersecta(poli2);
      //System.out.println("TANGENTES: " + poli2.esTangente(0, 0, poli));
      VisuPoligono vpoliInter = new VisuPoligono(poliIntersecta);
      /** Definimos un array polimorfo */
      Vista vv[] = new Vista[3];
      vv[0] = vpoli;
      vv[1] = vpoliInter;
      
      for (int i = 0; i<2; i++){
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

