/**
 * @Class Punto.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;

/** Representa un Punto 2D. */
public class Punto {

    /** Coordenada X del Punto. */
    protected double x;
    /** Coordenada Y del Punto. */
    protected double y;

    /** Crea un nuevo Punto con coordenadas por defecto (iguales a 0) */
    public Punto() {
        x = 0;
        y = 0;
    }

    /** Crea un nuevo Punto con coordenadas X e Y igual a xx e yy, 
    respectivamente. */
    public Punto(double xx, double yy) {
        x = xx;
        y = yy;
    }

    /** Crea un nuevo Punto copiando el Punto p. */
    public Punto(Punto p) {
        x = p.x;
        y = p.y;
    }

    /** Obtiene la distancia del Punto actual al Punto p, calculada como: 
    distancia = raiz ((p.x - x)2 + (p.y - y)2). */
    public double distancia(Punto p) {
        double dX, dY;
        dX = Math.abs(p.x - x);
        dY = Math.abs(p.y - y);
        return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
    }

    /** Obtiene el doble del �rea que forman el tri�ngulo definido por el Punto 
    actual y los Puntos a y b, en el orden (*this, a, b). */
    public double areaTriangulo2(Punto a, Punto b) {
        return x * a.y - y * a.x + a.x * b.y - a.y * b.x + b.x * y - b.y * x;
    }

    /** Compara el Punto actual con el Punto p, devolviendo true si son iguales 
    (si coinciden coordenada a coordenada), y false en caso contrario. */
    public boolean igual(Punto p) {
        return x == p.x && y == p.y;
    }

    /** Compara el Punto actual con el Punto p, devolviendo true si son 
    distintos (si alguna de las coordenadas no coinciden), y false en caso contrario. */
    public boolean distinto(Punto p) {
        return x != p.x || y != p.y;
    }

    /** Obtiene un Punto copia del actual. */
    public Punto copia() {
        return new Punto(x, y);
    }

    /** El Punto actual pasa a ser una copia del Punto p. */
    public void copia(Punto p) {
        x = p.x;
        y = p.y;
    }

    /** Devuelve el Punto para ser leido. */
    public Punto lee() {
        return this;
    }

    /** Devuelve la coordenada X del Punto. */
    public double leex() {
        return x;
    }

    /** Devuelve la coordenada Y del Punto. */
    public double leey() {
        return y;
    }

    /** Establece las coordenadas X e Y del Punto con los valores de xx e yy, 
    respectivamente. */
    public void asigna(double xx, double yy) {
        x = xx;
        y = yy;
    }

    /** Establece la coordenada X del Punto. */
    public void asignax(double xx) {
        x = xx;
    }

    /** Establece la coordenada Y del Punto. */
    public void asignay(double yy) {
        y = yy;
    }

    /** Realiza la suma de dos Puntos, devolviendo la suma en otro Punto. */
    public Punto suma(Punto p) {
        return new Punto(x + p.x, y + p.y);
    }

    /** Realiza la suma de dos Puntos, almacenando dicha suma en el Punto 
    actual. */
    public void sumaAsigna(Punto p) {
        x += p.x;
        y += p.y;
    }

    /** Realiza la resta de dos Puntos, devolviendo la suma en otro Punto. */
    public Punto resta(Punto p) {
        return new Punto(x - p.x, y - p.y);
    }

    /** Realiza la resta de dos Puntos, almacenando dicha resta en el Punto 
    actual. */
    public void restaAsigna(Punto p) {
        x -= p.x;
        y -= p.y;
    }

    /** Realiza el producto del Punto actual por un escalar, devolviendo el 
    producto en otro Punto. */
    public Punto producto(double d) {
        return new Punto(x * d, y * d);
    }

    /** Realiza el producto del Punto actual por un escalar, almacenando dicho 
    producto en el Punto actual. */
    public void productoAsigna(double d) {
        x *= d;
        y *= d;
    }

    /** Realiza la divisi�n del Punto actual por un escalar, devolviendo la 
    divisi�n en otro Punto. */
    public Punto division(double d) {
        return new Punto(x / d, y / d);
    }

    /** Realiza la divisi�n del Punto actual por un escalar, almacenando dicha 
    divisi�n en el Punto actual. */
    public void divisionAsigna(double d) {
        x /= d;
        y /= d;
    }

    /** Indica si el Punto est� a la izquierda del segmento definido por los 
    Puntos ab. */
    public boolean izquierda(Punto a, Punto b) {
        return areaTriangulo2(a, b) > 0.0;
    }

    /** Indica si el Punto est� a la derecha del segmento definido por los 
    Puntos ab. */
    public boolean derecha(Punto a, Punto b) {
        return areaTriangulo2(a, b) < 0.0;
    }

    /** Indica si los tres Puntos son colineales. */
    public boolean colineal(Punto a, Punto b) {
        return 1-Math.abs(areaTriangulo2(a, b)) > 1- Geometria.CERO;
    }

    /** Indica si el Punto est� a la izquierda o es colineal al segmento 
    definido por los Puntos ab. */
    public boolean izquierdaSobre(Punto a, Punto b) {
        return areaTriangulo2(a, b) >= 0.0;
    }

    /** Indica si el Punto est� a la derecha o es colineal al segmento definido 
    por los Puntos ab. */
    public boolean derechaSobre(Punto a, Punto b) {
        return areaTriangulo2(a, b) <= 0.0;
    }

    /** Indica la pendiente que forma con el Punto p. */
    public double pendiente(Punto p) {
        if (Math.abs(x - p.x) < 0) {
            return Geometria.INFINITO;
        }

        return (p.y - y) / (p.x - x);
    }

    /** Muestra en pantalla los valores de las coordenadas del Punto. */
    public void out() {
        System.out.print("Coordenada x: ");
        System.out.println(x);
        System.out.print("Coordenada y: ");
        System.out.println(y);
    }

    //******************************* METODOS CREADOS *************************/
    
    /**
     * Cuadrante que ocupa en punto pt tomando el punto (this) como origen
     * @param pt Punto del cual se desea saber el cuadrante
     * @return El cuadrante que ocupa en punto
     */
    public int cuadrante(Punto pt) {
        double difX = pt.x - x;
        double difY = pt.y - y;

        if (difX > 0 && difY >= 0) {
            return 1;
        } else if (difX >= 0 && difY < 0) {
            return 4;
        } else if (difX <= 0 && difY > 0) {
            return 2;
        } else if (difX < 0 && difY <= 0) {
            return 3;
        } else {
            return 0; //Suponemos punto Origen
        }

    }
    
    
    /**
     * Ángulo que forma con el Punto pt (en radianres) 
     * @param pt
     * @return Ángulo en radianes
     */
    public float angulo(Punto pt) {
        return (float) Math.atan2(pt.y-y, pt.x-x);
    }
    
    /**
     * Dice si el punto está entre el punto a y b
     * @param a
     * @param b
     * @return True si está entre los dos punto o False si no lo está
     */
    public boolean entre(Punto a, Punto b) {
        if (colineal(a, b)) {//Es colineal
            if (a.x != b.x) {
                return (a.x <= x && x <= b.x || a.x >= x && x >= b.x);
            } else {
                return (a.y <= y && y <= b.y || a.y >= y && y >= b.y);
            }
        } else {//No es colineal
            return false;
        }
    }
    
    /**
     * Rota el punto 90º
     */
    public void rotar90() {
        double aux =  x;
        x = -y;
        y = aux;
    }
    
    /**
     * @see Rota el punto 270º
     */
    public void rotar270() {
        double aux = x;
        x = y;
        y = aux * (-1);
    }
    
    /**
     * Mueve un punto un desplazamiento en 'x' e 'y'
     * @param dx
     * @param dy
     */
    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    /**
     * Determina el cuadrante en el que se encuentra el punto
     * @return Cuadrante en el que se encuentra
     */
    public int cuadrante() {
        if (x > 0 && y >= 0) {
            return 1;
        } else if (x >= 0 && y < 0) {
            return 4;
        } else if (x <= 0 && y > 0) {
            return 2;
        } else if (x < 0 && y <= 0) {
            return 3;
        } else {
            return 0; //Suponemos punto Origen
        }
    }
    
    /**
     * Determina cual es el punto de menor abscisa
     * @param p
     * @return -1 (<) | 0 (==) | 1 (>)
     */
    public int compX(Punto p) {
        if (x < p.x || (Math.abs(x - p.x) < Geometria.CERO && y > p.y)) {
            return -1;
        } else if (Math.abs(x - p.x) < Geometria.CERO && Math.abs(y - p.y) < Geometria.CERO) {
            return 0;
        } else {
            return 1;
        }
    }
    
    /**
     * Determina cual es el punto de menor ordenada
     * @param p
     * @return -1 (<) | 0 (==) | 1 (>)
     */
    public int compY(Punto p) {
        if (y < p.y || (Math.abs(y - p.y) < Geometria.CERO && y > p.x)) {
            return -1;
        } else if (Math.abs(x - p.x) < Geometria.CERO && Math.abs(y - p.y) < Geometria.CERO) {
            return 0;
        } else {
            return 1;
        }
    }
    
    /**
     * Establece las coordenadas del punto a partir de sus polares
     * @param longe
     * @param angulo 
     */
    public void setPolares(float longe, float angulo) {
        x = longe * Math.cos(angulo);
        y = longe * Math.sin(angulo);
    }
}
