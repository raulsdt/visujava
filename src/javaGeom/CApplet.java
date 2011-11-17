package javaGeom;

import java.awt.*;
import java.util.ArrayList;
import visujava.Geometria;
import visujava.Punto;
import visujava.Vista;
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
      //Probamos el vector
      Vector v1 = new Vector(-40, -50);
      VisuVector vv1 = new VisuVector(v1);
      
      Vector v2 = new Vector(20, 20);
      VisuVector vv2 = new VisuVector(v2);
      
      //Probamos la recta
      RectaPrm r1 = new RectaPrm(v1,v2);
      VisuRectaPrm vr1 = new VisuRectaPrm(r1);
      
      Punto p1 = new Punto(20,20);
      RectaPrm paralela = r1.paralelaDistancia(10);
      VisuRectaPrm vparalela = new VisuRectaPrm(paralela);
      
      
      
      /** Definimos un array polimorfo */
      ArrayList<Vista> vv = new ArrayList<Vista>();
      vv.add(vv1);
      vv.add(vv2);
      vv.add(vr1);
      vv.add(vparalela);
      
      
      for (int i = 0; i<vv.size(); i++){
          Vista obj = vv.get(i); //enganche polimorfo
          obj.pinta(g);     //ligadura dinámica
      }

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

