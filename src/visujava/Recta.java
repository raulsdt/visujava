/**
 * @Class Recta.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;

import java.util.ArrayList;


public class Recta {
    
    private Punto a;
    private Punto b;

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
    
    /**
     * Intersección de recta con recta
     * @param r Recta
     * @return El punto si hay intersección o null si no la hay
     */
    public Punto intersecta(Recta r){
        double a0, a1, b0, b1, c0, c1, d0, d1;
	a0 = leeB().leex(); a1 = leeB().leey();
	b0 = leeA().leex(); b1 = leeA().leey();
	c0 = r.leeB().leex(); c1 = r.leeB().leey();
	d0 = r.leeA().leex(); d1 = r.leeA().leey();
	double denominador = a0 *(d1-c1) + b0*(c1-d1) + d0*(b1-a1) + c0*(a1-b1);
	if (denominador == Geometria.CERO) return null;

	double s = (a0*(d1-c1) + c0*(a1-d1) + d0*(c1-a1)) / denominador;
	double t = (-1)*(a0*(c1-b1) + b0*(a1-c1) + c0*(b1-a1)) / denominador;

	double x = a0 + s*(b0-a0);
	double y = a1 + s*(b1-a1);

	return new Punto(x, y);

    }
    
    /**
     * Intersección de recta - segmento
     * @param s Segmento
     * @return El punto de intersección o null si no hay intersección
     */
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
    
    /**
     * Inteersección de recta - poligono
     * @param p Poligono
     * @return una lista con los puntos de intersección o null si no lo hay
     */
    public ArrayList<Punto> intersecta(Poligono p){
        ArrayList<Punto> array = new ArrayList<Punto>();
        Punto punto = new Punto();
        
        for(int i=0;i< p.nVertices;i++){
            punto = intersecta(new Segmento(p.lee(i),p.lee((i+1) % p.nVertices)));
            if(punto != null){
                array.add(punto);
            }
        }
        
        if(array.isEmpty()){
            return null;
        }else{
            return array;
        }
    }

    /**
     * @return the a
     */
    public Punto leeA() {
        return a;
    }

    /**
     * @return the b
     */
    public Punto leeB() {
        return b;
    }

  
    
}
