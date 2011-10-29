
/******************************************************************************
 Clase: Segmento.java
 * author: Jose Manuel Serrano
 * author: Raúl Salazar
 * Cambios desde netbeans push
******************************************************************************/

package visujava;

import java.util.*;
import java.math.*;
import java.io.*;

/** Representa un Segmento definido por dos Puntos. */
public class Segmento {
    
    /** Punto inferior del Segmento. */
    protected Punto a;
    /** Punto superior del Segmento. */
    protected Punto b;
    
    /** Contruye un Segmento con valores por defecto (Punto superior e inferior igual a (0,0). */
    public Segmento() {
        b = new Punto ();
        a = new Punto ();
    }
    
    /** Construye un Segmento con un Punto inferior igual a ii y un Punto superior igual a ss. */
    public Segmento (Punto ii,Punto ss) {
        a=ii; b=ss;
    }
    
    /** Construye un Segmento copia del Segmento sg. */
    public Segmento (Segmento sg) {
        //i = new Punto (sg.i);
        //b = new Punto (sg.b);
        a=sg.a; b=sg.b;
    }
    
    /** Construye un Segmento a partir de las coordenadas del Punto inferior y 
     del Punto superior. */
    public Segmento (double ax, double ay, double bx, double by) {
        a = new Punto (ax,ay);
        b = new Punto (bx,by);
    }
    
    /** Obtiene el doble �rea formada por el tri�ngulo compuesto por el 
     Segmento actual y la uni�n de los extremos de dicho Segmento con el Punto p. */
    public double areaTriangulo2 (Punto p) {
        return p.areaTriangulo2 (a,b);
    }
    
    
    /** Devuelve la longitud del Segmento, utilizando el m�todo distancia de la
     clase Punto. */
    public double longitud () {
        return a.distancia (b);
    }
    
    /** Compara el Segmento actual con el Segmento sg, devolviendo true si son
     iguales, es decir coinciden sus Puntos inferior y superior, y false en
     caso contrario. */
    public boolean igual (Segmento sg) {
        return a.igual (sg.a) && b.igual (sg.b);
    }
    
    /** Compara el Segmento actual con el Segmento sg, devolviendo true si son
     distintos, es decir el Punto inferior o superior es distinto, y false en
     caso contrario. */
    public boolean distinto (Segmento sg) {
        return a.distinto (sg.a) || b.distinto (sg.b);
    }
    
    /** Obtiene una copia del Segmento actual. */
    public Segmento copia () {
        return new Segmento (a,b);
    }
    
    /** Obtiene una copia en el Segmento actual del Segmento sg. */
    public void copia (Segmento sg) {
        a.copia (sg.a);
        b.copia (sg.b);
    }
    
    /** Obtiene el Segmento actual. */
    public Segmento lee () {
        return this;
    }
    
    /** Obtiene el Punto inferior. */
    public Punto leea () {
        return a;
    }
    
    /** Obtiene la coordenada X del Punto inferior. */
    public double leeax () {
        return a.leex ();
    }
    
    /** Obtiene la coordenada Y del Punto inferior. */
    public double leeay () {
        return a.leey ();
    }

    /** Obtiene el Punto superior. */
    public Punto leeb () {
        return b;
    }
    
    /** Obtiene la coordenada X del Punto superior. */
    public double leebx () {
        return b.leex ();
    }
    
    /** Obtiene la coordenada Y del Punto superior. */
    public double leeby () {
        return b.leey ();
    }
    
    /** Establece el Punto inferior con las coordenadas del Punto p. */
    public void asignai (Punto p) {
        a.copia (p);
    }
    
    /** Establece el Punto inferior con los valores xx e yy para las coordenadas
     X e Y, respectivamente. */
    public void asignaa (double xx,double yy) {
        a.asigna (xx,yy);
    }
    
    /** Establece la coordenada X del Punto inferior. */
    public void asignaax (double xx) {
        a.asignax (xx);
    }
    
    /** Establece la coordenada Y del Punto inferior. */
    public void asignaay (double yy) {
        a.asignay (yy);
    }
    
    /** Establece el Punto superior con las coordenadas del Punto p. */
    public void asignab (Punto p) {
        b.copia (p);
    }
    
    /** Establece el Punto inferior con los valores xx e yy para las coordenadas
     X e Y, respectivamente. */
    public void asignab (double xx,double yy) {
        b.asigna (xx,yy);
    }
    
    /** Establece la coordenada X del Punto superior. */
    public void asignabx (double xx) {
        b.asignax (xx);
    }
        
    /** Establece la coordenada Y del Punto superior. */
    public void asignaby (double yy) {
        b.asignay (yy);
    }
    
    /** Indica si el Segmento es horizontal, en cuyo caso se devuelve true, y en
     caso contrario se devuelve false. */
    public boolean esHorizontal () {
        return Math.abs (b.leey() - a.leey()) == 0.0;
    }
    
    /** Indica si el Segmento es vertical, en cuyo caso se devuelve true, y en
     caso contrario se devuelve false. */
    public boolean esVertical () {
        return Math.abs (b.leex() - a.leex()) == 0.0;
    }
    
    /** Indica si el Punto p est� a la izquierda del Segmento. Para ello, se
     utiliza el m�todo "izquierda" definido en la clase Punto. */
    public boolean izquierda (Punto p) {
        return p.izquierda (a,b);
    }
    
    /** Muestra en pantalla la informaci�n del Segmento. */
    public void out () {
        System.out.println ("Punto inferior: ");
        a.out ();
        System.out.println ("Punto superior: ");
        b.out ();
    }
    
    /************************** METODOS PROPIOS *************************/
    
    /**
     * Intersección de segmentos
     * @param se
     * @return True si se produce intersección, False en caso contrario
     */
    public boolean interseccion(Segmento se){
        if(se.a.colineal(a, b) || se.b.colineal(a, b)
                || a.colineal(se.a,se.b) || b.colineal(se.a, se.b)){
            return false;
        }else{
            return ( (se.a.izquierda(a, b) ^ se.b.izquierda(a, b)) 
                    && (a.izquierda(se.a, se.b) ^ b.izquierda(se.a, se.b)) );
        }
    }
    
    /**
     * Punto de intersección entre dos segmentos
     * @param se
     * @return 
     */
    public Punto puntoInterseccion(Segmento se){
        if(interseccion(se)){
            double m1,m2,c1,c2;
            double x,y;
            //Obtenemos las formas implicitas de los segmentos
            // y = mx+c , siendo "m" la pendiente y "c" el termino independiente
            
            // 1º Segmento
            m1 = (b.y - a.y )/(b.x - a.x);
            c1 = b.y - m1 * b.x;
            
            // 2º Segmento
            m2 = (se.b.y - se.a.y )/(se.b.x - se.a.x);
            c2 = se.b.y - m2 * se.b.x;
            
            //Resolvemos el sistema de ecuaciones
            x = (c1-c2)/(m2-m1);
            y = m1 * x +c1;
            
            return new Punto(x,y); 
        }else{
            return null;
        }
    }
    
    /**
     * Intersección impropia de segmentos
     * @param se
     * @return 
     */
    public boolean interseccionImpropia(Segmento se){
        if(se.a.entre(a, b) || se.b.entre(a, b)
                || a.entre(se.a, se.b) || b.entre(se.a, se.b)){
            return true;
        }else{
            return ( (se.a.izquierda(a, b) ^ se.b.izquierda(a, b)) 
                    && (a.izquierda(se.a, se.b) ^ b.izquierda(se.a, se.b)) );
        }
    }
    
    /**
     * Punto de intersección impropia entre dos segmentos
     * @param se
     * @return 
     */
    public Punto puntoInterseccionImpropia(Segmento se){
        //Sabemos que uno de los puntos es la intersección
        //El que esté entre un segmento, ese es el punto
        if(interseccionImpropia(se)){         
            if(a.entre(se.a, se.b)){
                return a;
            }else{
                if(b.entre(se.a, se.b)){
                    return b;
                }else{
                    if(se.a.entre(a, b)){
                        return se.a;
                    }else{
                        return se.b;
                    }
                }
            }
        }else{
            return null;
        }
    }
    
    /**
     * Solapamiento de segmentos
     * @param se
     * @return True si se solapan los segmentos y False en caso contrario
     */
    public boolean solapamiento(Segmento se){
        //Vemos si son colineales
        if(a.colineal(b, se.a) || a.colineal(b, se.b)
                || se.a.colineal(se.b,a) || se.a.colineal(se.b, b)){
            if(se.a.entre(a, b) || se.b.entre(a, b)
                || a.entre(se.a, se.b) || b.entre(se.a, se.b)){
                return true; // Se solapan
            }else{
                return false; // Son colineales pero no se solapan
            }
        }else{
            return false; // No colineales -- No solapamiento
        }
    }
    
    /**
     * Segmento dentro de otro segmento
     * @param se
     * @return True si el segmento se está dentro y False si no lo está
     */
    public boolean dentro(Segmento se){
        //Tienen que solaparse y además estar uno dentro del otro
        if (solapamiento(se)){
            //Comprovamos si alguno de los segmentos está dentro del otro
            if(a.entre(se.a, se.b) && b.entre(se.a, se.b)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    /**
     * Detecta si el punto pertenece al segmento
     * @param p
     * @return True si el punto se encuentra en el segmento y False en caso contrario
     */
    public boolean contienePunto(Punto p){
        if(p.entre(a, b)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * @see Rota el segmento 90º
     */
    public void rotar90(){
        a.rotar90();
        b.rotar90();
    }
    
    /**
     * @see Rota el segmento 207º
     */
    public void rotar270(){
        a.rotar270();
        b.rotar270();
    }
    
    /**
     * @see Compara si (this) está a la izquierda, derecha o es igual que el segmento
     * @param se
     * @return izquierda (-1) | igual (0) | derecha (1)
     */
    public int compSegmento(Segmento se){
        if(a.izquierda(se.a, se.b) && b.izquierda(se.a, se.b)){
            return -1;
        }else{
            if(a.derecha(se.a, se.b) && b.derecha(se.a, se.b)){
                return 1;
            }else{
                return 0; // ¿Y si se intersectan? Preguntar...
            }
        }
    }
}


