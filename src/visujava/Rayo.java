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
        if (p.colineal(leeA(), leeB())) {
            if (leeA().x - leeB().x <= Geometria.CERO) {//Es vertical
                if (leeB().y - leeA().y > Geometria.CERO) {//Vertical - Sentido positivo
                    return (p.y >= leeA().y);
                } else {//Vertical - Sentido negativo
                    return (p.y <= leeA().y);
                }
            } else {
                if (leeB().x - leeA().x > Geometria.CERO) { //Diferenciamos sentido (Derecha o izquierda)
                    return (p.leex() >= leeA().x);
                } else {
                    return (p.leex() <= leeA().x);
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
        Punto p = new Punto(new Recta(r.leeA(), r.leeB()).intersecta(this));
        
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
