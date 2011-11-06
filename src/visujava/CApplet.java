/**
 * @Class CApplet.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */

package visujava;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class CApplet extends java.applet.Applet {

  final static int NUMERO_RANDOM =  60;
    
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
      /** Definimos un array polimorfo */
      ArrayList<Vista> vv = new ArrayList<Vista>();

      
      //Operaciones a realizar
      
      //1.-Generar una nube de punto nb de 50 puntos aleatorios
          NubePuntos nb = new NubePuntos(50, 80);
          VisuNube vnb = new VisuNube(nb);

          //      vv.add(vnb);      // 1.-
    
      //2.-Girar 90 grados a la izquierda la nube de puntos 
      //y añadir a nb la nube resultante
          NubePuntos nb90 = new NubePuntos();
          Punto aux;
          for(int i = 0;i<nb.tamanoNube(); i++){
              aux = new Punto(nb.getPunto(i));
              aux.rotar90();
              nb90.anadirPunto(aux);
          }      
        //Añadimos los puntos rotados a la nube nb
          for(int i = 0; i < nb90.tamanoNube(); i++){
              nb.anadirPunto(new Punto(nb90.getPunto(i)));
          }
          VisuNube vnb90 = new VisuNube(nb);
          
          //      vv.add(vnb90);    // 2.-
      
      //3.-Ordenar los puntos de arriba hacia abajo. 
      //Numerar cada punto utilizando drawString en visuNube
          nb.ordenaY();
          VisuNube vnbOrd = new VisuNube(nb);
          
          vv.add(vnbOrd);     // 3.-
      
      
      //4.-Escoger el punto de mayor y menor ordenada y el 
      //de mayor y menor abscisa
      
        //Cogemos el punto de mayor y menor ordenada
          Punto mayorOrdenada = new Punto(nb.getPunto(0));
          Punto menorOrdenada = new Punto(nb.getPunto(nb.tamanoNube()-1));

        //Cogemos el punto de mayor y menor abscisa (Ordenamos en X)
          NubePuntos nbOrdX = nb.ordenaXnube();
          Punto menorAbscisa = new Punto(nbOrdX.getPunto(0));
          Punto mayorAbscisa = new Punto(nbOrdX.getPunto(nbOrdX.tamanoNube()-1));
      
      //5.-Formar un poligono con esos cuatro puntos y triangularlo
      //obteniendo dos triángulos
        
          ArrayList<Vertice> vertices = new ArrayList<Vertice>();
          vertices.add(new Vertice(menorOrdenada));
          vertices.add(new Vertice(mayorAbscisa));
          vertices.add(new Vertice(mayorOrdenada));
          vertices.add(new Vertice(menorAbscisa));
          Poligono poli = new Poligono(vertices, 4);

          VisuPoligono vpoli = new VisuPoligono(poli);
      
        //Triangulamos el Poligono

          Poligono triangulo1 = new Poligono();
          triangulo1.anade(vertices.get(0));
          triangulo1.anade(vertices.get(1));
          triangulo1.anade(vertices.get(2));
          VisuPoligono vtrg1 = new VisuPoligono(triangulo1);


          Poligono triangulo2 = new Poligono();
          triangulo2.anade(vertices.get(2));
          triangulo2.anade(vertices.get(3));
          triangulo2.anade(vertices.get(0));
          VisuPoligono vtrg2 = new VisuPoligono(triangulo2);
          
          vv.add(vpoli);      // 4.-
          vv.add(vtrg1);      // 5.-
          vv.add(vtrg2);      // 5.-


      //6.-Escoger aleariamente puntos de la nube y formar
      // una recta, un segmento y un rayo (intersecciones entre ellos)
            Random rnd = new Random(NUMERO_RANDOM);

            //Formamos una recta
            Recta r = new Recta(nb.getPunto(rnd.nextInt(Geometria.RANGO)),nb.getPunto(rnd.nextInt(Geometria.RANGO)));
            VisuRecta vr = new VisuRecta(r);
            
            vv.add(vr);         // 6.- Recta

            //Formamos un segmento
            Segmento s = new Segmento(nb.getPunto(rnd.nextInt(Geometria.RANGO)),nb.getPunto(rnd.nextInt(Geometria.RANGO)));
            VisuSegmento vs = new VisuSegmento(s);
            
            vv.add(vs);         // 6.- Segmento
            
            //Formamos un rayo
            Rayo ry = new Rayo(nb.getPunto(rnd.nextInt(Geometria.RANGO)),nb.getPunto(rnd.nextInt(Geometria.RANGO)));
            VisuRayo vry = new VisuRayo(ry);
            
            vv.add(vry);        // 6.- Rayo
        
        //INTERSECCIONES
            Punto interseccion = new Punto();
            //--> Rayo -Recta
            System.out.println("\n***************************************");
            System.out.println("6.- Intersección Rayo - Recta");
            interseccion = ry.intersecta(r);
            if(interseccion == null){
                System.out.println("NO INTERSECTA");
            }else{
                System.out.println("INTERSECTA");
                
                VisuPunto vinterR = new VisuPunto(interseccion);
                vv.add(vinterR);
            }
            
            //--> Recta - Segmento
            System.out.println("\n***************************************");
            System.out.println("6.- Intersección Recta - Segmento");
            interseccion = r.intersecta(s);
            if(interseccion == null){
                System.out.println("NO INTERSECTA");
            }else{
                VisuPunto vinterS = new VisuPunto(interseccion);
                vv.add(vinterS);
                System.out.println("INTERSECTA");
            }
            
            //--> Rayo - Segmento
            System.out.println("\n***************************************");
            System.out.println("6.- Intersección Rayo - Segmento");
            interseccion = ry.intersecta(s);
            if(interseccion == null){
                System.out.println("NO INTERSECTA");
            }else{
                VisuPunto vinterRY = new VisuPunto(interseccion);
                vv.add(vinterRY);
                System.out.println("INTERSECTA");
            }
            
            //--> Recta - Aristas
            System.out.println("\n***************************************");
            System.out.println("6.- Intersección Recta - Aristas");
            ArrayList<Punto> interRA = new ArrayList<Punto>();
            
            interRA = r.intersecta(triangulo1);
            if(interRA == null){
                System.out.println("NO INTERSECTA");
            }else{
                for(int i = 0;i < interRA.size(); i++){
                    vv.add(new VisuPunto(interRA.get(i)));
                }
                System.out.println("INTERSECTA");
            }
            
            interRA = r.intersecta(triangulo2);
            if(interRA == null){
                System.out.println("NO INTERSECTA");
            }else{
                for(int i = 0;i < interRA.size(); i++){
                    vv.add(new VisuPunto(interRA.get(i)));
                }
                System.out.println("INTERSECTA");
            }
            
            //--> Rayo - Aristas
            System.out.println("\n***************************************");
            System.out.println("6.- Intersección Rayo - Aristas");
            interRA = ry.intersecta(triangulo1);
            if(interRA == null){
                System.out.println("NO INTERSECTA");
            }else{
                for(int i = 0;i < interRA.size(); i++){
                    vv.add(new VisuPunto(interRA.get(i)));
                }
                System.out.println("INTERSECTA");
            }
            
            interRA = ry.intersecta(triangulo2);
            if(interRA == null){
                System.out.println("NO INTERSECTA");
            }else{
                for(int i = 0;i < interRA.size(); i++){
                    vv.add(new VisuPunto(interRA.get(i)));
                }
                System.out.println("INTERSECTA");
            }
            
      
        
      //7.-Área del poligono
      System.out.println("\n***************************************");  
      System.out.println("7.- El área del poligo no es: " + poli.areaPoligono());
      
      //Fin del procesamiento
      System.out.println("\nFIN DEL PROCESAMIENTO");
      
      
      //Dibujamos
      for (int i = 0; i<vv.size(); i++){
          Vista obj = vv.get(i); //enganche polimorfo
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

