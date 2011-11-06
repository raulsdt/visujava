/**
 * @Class Rayo.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;

import java.util.ArrayList;

public class Rayo extends Recta {
    
    /**
     * Constructor de la clase Rayo (dando dos puntos)
     * @param oo Punto de Origen
     * @param cc Punto que influye en la dirección del rayo
     */
    public Rayo(Punto oo, Punto cc) {
        super(oo, cc);
    }

    /**
     * Constructor de la clase Rayo (dandas las cooredandas de dos puntos)
     * @param ox Coordenada x del punto de origen
     * @param oy Coordenada y del punto de origen
     * @param cx Coordenada x del punto dirección
     * @param cy Coordenada y del punto dirección
     */
    public Rayo(double ox, double oy, double cx, double cy) {
        super(ox, oy, cx, cy);
    }
    
    /**
     * Contructor de la clase Rayo (dada una recta)
     * @param r Recta
     */
    public Rayo(Recta r) {
        super(r);
    }
    
    /**
     * Pertenece un punto al rayo
     * @param p el punto quye queremos comprobar
     * @return True si el punto pertenece al rayo o False si no pertenece
     */
    private boolean pertenece(Punto p) {
        if (p.colineal(leeA(), leeB())) {
            if(leeA().cuadrante(leeB()) == leeA().cuadrante(p)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * Intersección Rayo - Recta
     * @param r Recta
     * @return El punto de intersección o null si no existe intersección
     */
    public Punto intersecta(Recta r) {
        Punto p = new Punto(r.intersecta(new Recta(this.leeA(),this.leeB())));    
        if(pertenece(p)){
            return p;
        }
        return null;
    }
    
    /**
     * Intersección de Rayo - Rayo
     * @param r Rayo
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(Rayo r) {
        Punto p = new Punto();
        
        Recta r1 = new Recta(r.leeA(), r.leeB());
        p = this.intersecta(r1);
        
        if(p != null && pertenece(p) && r.pertenece(p)){
            return p;
        }
        return null;
    }

    /**
     * Intersección Rayo - Segmento
     * @param s Segmento
     * @return El punto de intersección o null si no intersecta
     */
    public Punto intersecta(Segmento s) {
        Punto p = new Recta(s.a, s.b).intersecta(this);
        
        if(p!=null && pertenece(p) && s.contiene(p)){
            return p;
        }
        return null;
    }

    /**
     * Intersección Rayo - Poligono
     * @param p Poligono
     * @return El punto de intersección o null si no intersecta
     */
    public ArrayList<Punto> intersecta(Poligono p) {
        ArrayList<Punto> array = new ArrayList<Punto>();
        Punto punto = new Punto();
        
        for(int i=0;i< p.nVertices;i++){
            punto = intersecta(new Segmento(p.lee(i),p.lee( (i+1) % p.nVertices)));
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
}
