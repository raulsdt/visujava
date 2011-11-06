/**
 * @Class segmento.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
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
        b = new Punto();
        a = new Punto();
    }

    /** Construye un Segmento con un Punto inferior igual a ii y un Punto superior igual a ss. */
    public Segmento(Punto ii, Punto ss) {
        a = ii;
        b = ss;
    }

    /** Construye un Segmento copia del Segmento sg. */
    public Segmento(Segmento sg) {
        //i = new Punto (sg.i);
        //b = new Punto (sg.b);
        a = sg.a;
        b = sg.b;
    }

    /** Construye un Segmento a partir de las coordenadas del Punto inferior y 
    del Punto superior. */
    public Segmento(double ax, double ay, double bx, double by) {
        a = new Punto(ax, ay);
        b = new Punto(bx, by);
    }

    /** Obtiene el doble �rea formada por el tri�ngulo compuesto por el 
    Segmento actual y la uni�n de los extremos de dicho Segmento con el Punto p. */
    public double areaTriangulo2(Punto p) {
        return p.areaTriangulo2(a, b);
    }

    /** Devuelve la longitud del Segmento, utilizando el m�todo distancia de la
    clase Punto. */
    public double longitud() {
        return a.distancia(b);
    }

    /** Compara el Segmento actual con el Segmento sg, devolviendo true si son
    iguales, es decir coinciden sus Puntos inferior y superior, y false en
    caso contrario. */
    public boolean igual(Segmento sg) {
        return a.igual(sg.a) && b.igual(sg.b);
    }

    /** Compara el Segmento actual con el Segmento sg, devolviendo true si son
    distintos, es decir el Punto inferior o superior es distinto, y false en
    caso contrario. */
    public boolean distinto(Segmento sg) {
        return a.distinto(sg.a) || b.distinto(sg.b);
    }

    /** Obtiene una copia del Segmento actual. */
    public Segmento copia() {
        return new Segmento(a, b);
    }

    /** Obtiene una copia en el Segmento actual del Segmento sg. */
    public void copia(Segmento sg) {
        a.copia(sg.a);
        b.copia(sg.b);
    }

    /** Obtiene el Segmento actual. */
    public Segmento lee() {
        return this;
    }

    /** Obtiene el Punto inferior. */
    public Punto leea() {
        return a;
    }

    /** Obtiene la coordenada X del Punto inferior. */
    public double leeax() {
        return a.leex();
    }

    /** Obtiene la coordenada Y del Punto inferior. */
    public double leeay() {
        return a.leey();
    }

    /** Obtiene el Punto superior. */
    public Punto leeb() {
        return b;
    }

    /** Obtiene la coordenada X del Punto superior. */
    public double leebx() {
        return b.leex();
    }

    /** Obtiene la coordenada Y del Punto superior. */
    public double leeby() {
        return b.leey();
    }

    /** Establece el Punto inferior con las coordenadas del Punto p. */
    public void asignai(Punto p) {
        a.copia(p);
    }

    /** Establece el Punto inferior con los valores xx e yy para las coordenadas
    X e Y, respectivamente. */
    public void asignaa(double xx, double yy) {
        a.asigna(xx, yy);
    }

    /** Establece la coordenada X del Punto inferior. */
    public void asignaax(double xx) {
        a.asignax(xx);
    }

    /** Establece la coordenada Y del Punto inferior. */
    public void asignaay(double yy) {
        a.asignay(yy);
    }
    
    /** Establece el Punto inferior con las coordenadas del Punto p. */
    public void asignaa(Punto p) {
        a.copia(p);
    }
    
    /** Establece el Punto superior con las coordenadas del Punto p. */
    public void asignab(Punto p) {
        b.copia(p);
    }

    /** Establece el Punto inferior con los valores xx e yy para las coordenadas
    X e Y, respectivamente. */
    public void asignab(double xx, double yy) {
        b.asigna(xx, yy);
    }

    /** Establece la coordenada X del Punto superior. */
    public void asignabx(double xx) {
        b.asignax(xx);
    }

    /** Establece la coordenada Y del Punto superior. */
    public void asignaby(double yy) {
        b.asignay(yy);
    }

    /** Indica si el Segmento es horizontal, en cuyo caso se devuelve true, y en
    caso contrario se devuelve false. */
    public boolean esHorizontal() {
        return Math.abs(b.leey() - a.leey()) == 0.0;
    }

    /** Indica si el Segmento es vertical, en cuyo caso se devuelve true, y en
    caso contrario se devuelve false. */
    public boolean esVertical() {
        return Math.abs(b.leex() - a.leex()) == 0.0;
    }

    /** Indica si el Punto p est� a la izquierda del Segmento. Para ello, se
    utiliza el m�todo "izquierda" definido en la clase Punto. */
    public boolean izquierda(Punto p) {
        return p.izquierda(a, b);
    }

    /** Muestra en pantalla la informaci�n del Segmento. */
    public void out() {
        System.out.println("Punto inferior: ");
        a.out();
        System.out.println("Punto superior: ");
        b.out();
    }

    /************************** METODOS PROPIOS *************************/
    /**
     * Intersección de segmentos
     * @param se
     * @return True si se produce intersección, False en caso contrario
     */
    public boolean intersecta(Segmento se) {
        if (se.a.colineal(a, b) || se.b.colineal(a, b)
                || a.colineal(se.a, se.b) || b.colineal(se.a, se.b)) {
            return false;
        } else {
            return ((se.a.izquierda(a, b) ^ se.b.izquierda(a, b))
                    && (a.izquierda(se.a, se.b) ^ b.izquierda(se.a, se.b)));
        }
    }

    /**
     * Punto de intersección entre dos segmentos
     * @param se
     * @return 
     */
    public Punto puntoInterseccion(Segmento se) {
        //Cambiada por esta dada por Lidia por que va bien en toos
        //los caso (la anterior fallaba en vertical)
        double a0, a1, b0, b1, c0, c1, d0, d1;
	a0 = leebx(); a1 = leeby();
	b0 = leeax(); b1 = leeay();
	c0 = se.leebx(); c1 = se.leeby();
	d0 = se.leeax(); d1 = se.leeay();
	double denominador = a0 *(d1-c1) + b0*(c1-d1) + d0*(b1-a1) + c0*(a1-b1);
	if (denominador == Geometria.CERO) return null;

	double s = (a0*(d1-c1) + c0*(a1-d1) + d0*(c1-a1)) / denominador;
	double t = (-1)*(a0*(c1-b1) + b0*(a1-c1) + c0*(b1-a1)) / denominador;

	double x = a0 + s*(b0-a0);
	double y = a1 + s*(b1-a1);

	if (0.0 <= s && s<= 1.0 && 0.0 <=t  && t<= 1.0) return new Punto(x, y);
	return null;
        
    }
    

    /**
     * Intersección impropia de segmentos
     * @param se
     * @return 
     */
    public boolean intersectaImpropia(Segmento se) {
        if (se.a.entre(a, b) || se.b.entre(a, b)
                || a.entre(se.a, se.b) || b.entre(se.a, se.b)) {
            return true;
        } else {
            return ((se.a.izquierda(a, b) ^ se.b.izquierda(a, b))
                    && (a.izquierda(se.a, se.b) ^ b.izquierda(se.a, se.b)));
        }
    }

    /**
     * Punto de intersección impropia entre dos segmentos
     * @param se
     * @return 
     */
    public Punto puntoIntersectaImpropia(Segmento se) {
        //Sabemos que uno de los puntos es la intersección
        //El que esté entre un segmento, ese es el punto
        if (intersectaImpropia(se)) {
            if (a.entre(se.a, se.b)) {
                return a;
            } else {
                if (b.entre(se.a, se.b)) {
                    return b;
                } else {
                    if (se.a.entre(a, b)) {
                        return se.a;
                    } else {
                        return se.b;
                    }
                }
            }
        } else {
            return null;
        }
    }

    /**
     * Solapamiento de segmentos
     * @param se
     * @return True si se solapan los segmentos y False en caso contrario
     */
    public boolean solapa(Segmento se) {
        //Vemos si son colineales
        if ( (a.colineal(b, se.a) && a.colineal(b, se.b))
                || (se.a.colineal(se.b, a) && se.a.colineal(se.b, b)) ) {
            if (se.a.entre(a, b) || se.b.entre(a, b)
                    || a.entre(se.a, se.b) || b.entre(se.a, se.b)) {
                return true; // Se solapan
            } else {
                return false; // Son colineales pero no se solapan
            }
        } else {
            return false; // No colineales -- No solapa
        }
    }

    /**
     * Segmento contiene de otro segmento
     * @param se
     * @return True si el segmento se está contiene y False si no lo está
     */
    public boolean contiene(Segmento se) {
        //Tienen que solaparse y además estar uno contiene del otro
        if (solapa(se)) {
            //Comprovamos si alguno de los segmentos está contiene del otro
            if (a.entre(se.a, se.b) && b.entre(se.a, se.b) || (se.a.entre(a, b) && se.b.entre(a, b))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Detecta si el punto pertenece al segmento
     * @param p
     * @return True si el punto se encuentra en el segmento y False en caso contrario
     */
    public boolean contiene(Punto p) {
        if (p.entre(a, b)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @see Rota el segmento 90º
     */
    public void rotar90() {
        a.rotar90();
        b.rotar90();
    }

    /**
     * @see Rota el segmento 207º
     */
    public void rotar270() {
        a.rotar270();
        b.rotar270();
    }

    /**
     * @see Calcula el punto medio del segmento
     * @return Punto medio del segmento
     */
    public Punto PuntoMedio() {
        return new Punto((a.x + b.x) / 2, (a.y + b.y) / 2);
    }

    /**
     * @see Compara si (this) está a la izquierda, derecha o es igual que el segmento
     * @param se
     * @return izquierda (-1) | se intersectan (0) | derecha (1) | coincidentes(2)
     */
    public int compX(Segmento se) {

        Segmento segmen = new Segmento();
        Segmento segmen2 = new Segmento();
        segmen.asignaa(a);
        segmen.asignab(b);
        segmen2.asignaa(se.leea());
        segmen2.asignab(se.leeb());
        try {

            // Ordenamos los puntos de un segmento
            ArrayList<Vertice> nubee = new ArrayList<Vertice>();
            nubee.add(new Vertice(segmen2.leea()));
            nubee.add(new Vertice(segmen2.leeb()));
            //Collections.sort(nubee,new ComparadorMin());

            ComparadorGrados.minimo = nubee.get(0);

            //Ordenamos los puntos por ángulo
            Collections.sort(nubee, new ComparadorGrados());
            segmen2.asignaa(nubee.get(0));
            segmen2.asignab(nubee.get(1));

            nubee.clear();

            //Ordenamos los puntos de otro segmento
            nubee.add(new Vertice(segmen.leea()));
            nubee.add(new Vertice(segmen.leeb()));
            Collections.sort(nubee, new ComparadorMin());

            ComparadorGrados.minimo = nubee.get(0);

            //Ordenamos los puntos por ángulo
            Collections.sort(nubee, new ComparadorGrados());
            segmen.asignaa(nubee.get(0));
            segmen.asignab(nubee.get(1));
        } catch (Exception e) {
            System.out.println("Error en la funcion CompX");
        }

        if (segmen.a.izquierda(segmen.b, segmen2.a) && segmen.b.izquierda(segmen.b, segmen2.b)) {
            return 1;
        } else {
            if (segmen.a.derecha(segmen.b, segmen2.a) && segmen.b.derecha(segmen.b, segmen2.b)) {
                return -1;
            } else {
                if (segmen.intersecta(segmen2)) {
                    return 0; // ¿Y si se intersectan? Preguntar...
                } else {
                     return 2;
                }
            }
        }
    }
}
