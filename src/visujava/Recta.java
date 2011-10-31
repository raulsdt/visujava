/*
 * Clase: Recta.java
 */
package visujava;

import java.util.ArrayList;

/**
 *
 * @author serrano
 */
public class Recta {
    
    protected Punto a;
    protected Punto b;

    public Recta(Punto aa, Punto bb){
        a=aa;
        b=bb;
    }
    
    public Recta(Recta r){
        a=r.a;
        b=r.b;
    }
    
    public Recta(double ax,double ay, double bx, double by){
        a = new Punto(ax,ay);
        b = new Punto(bx, by);
    }

    public Punto intersecta(Recta r){
            double m1, m2, c1, c2;
            double x, y;
            //Obtenemos las formas implicitas de los segmentos
            // y = mx+c , siendo "m" la pendiente y "c" el termino independiente

            // 1º Segmento
            m1 = (b.y - a.y) / (b.x - a.x);
            c1 = b.y - m1 * b.x;

            // 2º Segmento
            m2 = (r.b.y - r.a.y) / (r.b.x - r.a.x);
            c2 = r.b.y - m2 * r.b.x;
            
            if(Math.abs(m1-m2)< Geometria.CERO){
                return null;
            }

            //Resolvemos el sistema de ecuaciones
            x = (c1 - c2) / (m2 - m1);
            y = m1 * x + c1;

            return new Punto(x, y);

    }
    
    public Punto intersecta(Segmento s){
        
        Punto p = new Punto(intersecta(new Recta(s.leea(), s.leeb())));
        if(p!=null){
            if(s.contiene(p)){
                return p;
            }else{
                return null;
            }
        }
        return p;        
    }
    
    public ArrayList<Punto> intersecta(Poligono p){
        ArrayList<Punto> array = new ArrayList<Punto>();
        Punto punto = new Punto();
        
        for(int i=0;i< p.nVertices;i++){
            punto = intersecta(new Segmento(p.lee(i),p.lee(i+1)));
            if(punto != null){
                array.add(punto);
            }
        }
        return array;
    }
    
}
