/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;

import java.util.ArrayList;

/**
 *
 * @author serrano
 */
public class Rayo extends Recta {

    public Rayo(Punto oo, Punto cc) {
        super(oo, cc);
    }

    public Rayo(double ox, double oy, double cx, double cy) {
        super(ox, oy, cx, cy);
    }

    public Rayo(Recta r) {
        super(r);
    }

    private boolean pertenece(Punto p) {
        if (p.colineal(a, b)) {
            if (a.x - b.x <= Geometria.CERO) {//Es vertical
                if (b.y - a.y > Geometria.CERO) {//Vertical - Sentido positivo
                    return (p.y >= a.y);
                } else {//Vertical - Sentido negativo
                    return (p.y <= a.y);
                }
            } else {
                if (b.x - a.x > Geometria.CERO) { //Diferenciamos sentido (Derecha o izquierda)
                    return (p.leex() >= a.x);
                } else {
                    return (p.leex() <= a.x);
                }
            }
        }
        return false;
    }

    @Override
    public Punto intersecta(Recta r) {
        Punto p = new Punto(r.intersecta(this));
        
        if(pertenece(p)){
            return p;
        }
        return null;
    }
 
    public Punto intersecta(Rayo r) {
        Punto p = new Punto(new Recta(r.a,r.b).intersecta(this));
        
        if(p!=null && pertenece(p) && r.pertenece(p)){
            return p;
        }
        return null;
    }

    @Override
    public Punto intersecta(Segmento s) {
        Punto p = new Recta(s.a, s.b).intersecta(this);
        
        if(p!=null && pertenece(p) && s.contiene(p)){
            return p;
        }
        return null;
    }

    @Override 
    public ArrayList<Punto> intersecta(Poligono p) {
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
