package javaGeom;

import java.awt.*;
import math.geom2d.Point2D;
import visujava.*;
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
            
      VisuPunto p = new VisuPunto(new Punto(-40,40));
      //VisuSegmento s = new VisuSegmento(new Segmento(new Punto(4,4),new Punto(40,40)));
      
      /*
      Poligono pol = new Poligono();
      pol.anade(new Vertice(0, 0, pol));
      pol.anade(new Vertice(50, 0, pol));
      pol.anade(new Vertice(50, 50, pol));
      pol.anade(new Vertice(0, 50, pol));
      VisuPoligono vpol = new VisuPoligono(pol);
      */
      /** Definimos un array polimorfo */
      Vista vv[] = new Vista[4];
      //vv[0] = p;
      
      
      Punto k1 = new Punto (3,30);
      Punto k2 = new Punto (4,40);
      VisuPunto kv1 = new VisuPunto (k1); 
      VisuPunto kv2 = new VisuPunto (k2);      
      VisuRectaPrm vr = new VisuRectaPrm (new RectaPrm (k1,k2));
      
      vv[1] = vr;
      //vv[2] = kv1;
      //vv[3] = kv2;
        
      
      for (int i = 0; i<4; i++){
          Vista obj = vv[i]; //enganche polimorfo
          obj.pinta(g);     //ligadura dinámica
      }

    /*  
      Graphics2D g2 = (Graphics2D) g;
      Point2D kk1 = new Point2D (400, 30);
      kk1.draw(g2);
      Point2D kk2 = new Point2D (180, 100);
      kk2.draw(g2);
      */
  }
  
    @Override public void paint( Graphics g ) {
    try {
      Rectangle r = g.getClipBounds();
      Vista.ALTO  = (int)r.getHeight();
      Vista.ANCHO = (int)r.getWidth();  
      ejesCoordenadas(g);  
      pintar(g);
    }
    catch (Exception e) {
    }
   }

}

