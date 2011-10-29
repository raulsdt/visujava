/******************************************************************************
 Clase: Vertice.java
 *****************************************************************************/

package visujava;

import java.util.*;
import java.math.*;
import java.io.*;

/* Representa un v�rtice perteneciente a un pol�gono. */
public class Vertice extends Punto {
    /* Posici�n que ocupa dentro del pol�gono. */
    protected int posicion;
    /* Pol�gono al que pertenece. */
    protected Poligono polig;
    
    /** Construye un v�rtice por defecto, es decir no asociado a ning�n 
     pol�gono, con posici�n -1 (no pertenece a ning�n pol�gono) y coordenadas 
     (0,0). */
    public Vertice() {
        x = 0; y=0;
        posicion = 0;
        polig = null;
    }
    
    
    /** Construye un v�rtice asociado a un Punto, sin estar asociado a ning�n 
     pol�gono. Aunque no es correcto, ya que un v�rtice debe pertenecer a un
     pol�gono, es muy �til a la hora de inicializar v�rtices, que luego formen
     un pol�gono determinado. */    
    public Vertice (Punto p) {
        x = p.x; y=p.y;
	posicion = -1;
        polig = null;
    }
    
    /** Construye un v�rtice similar al anterior, con los valores xx e yy que se
     corresponden con las coordenadas X e Y del Punto p asociado al v�rtice. */
    public Vertice (double xx,double yy, Poligono pol) {
        x = xx; y = yy;
	posicion = -1;
        polig = pol;
    }
    
    /** Lee el valor de la x */
    public double leex () {
        return x;
    }
    
     /** Lee el valor de la y */
    public double leey () {
        return y;
    }

        
    /** Lee la posici�n asociada al v�rtice actual. */
    public int leePosicion () {
        return posicion;
    }
    
    /** Lee el pol�gono al que est� asociado el v�rtice. */
    public Poligono leePoligono () {
        return polig;
    }
    
    /** Modifica las coordenadas del Punto asociadas al v�rtice actual con los
     valores de las coordenadas del Punto p. */
    public void modificaPunto (Punto p) {
        x = p.x; y = p.y;
    }
    
    /** Modifica la posici�n del v�rtice dentro del pol�gono. Esta operaci�n
     se ha definido como protegida porque es peligroso que el usuario pueda
     modificar la posici�n del v�rtice. */
    protected void modificaPosicion (int pos) {
        posicion = pos;
    }
    
    /** Modifica el pol�gono al que pertenece el v�rtice v. De igual modo que el 
     m�todo anterior, tambi�n se ha declarado como un m�todo protegido. */
    protected void modificaPoligono (Poligono pl) {
        polig = pl;
    }

    
    /** Muestra por pantalla la informaci�n del v�rtice actual. */
    public void out () {
        System.out.print ("Coordenada x: ");
        System.out.println (x);
        System.out.print ("Coordenada y: ");
        System.out.println (y);

        System.out.print ("Posici�n: ");
        System.out.println (posicion);
    }
    
    /************************ METODOS PROPIOS *********************/
    
    /**
     * Vertice siguiente del polígono
     * @return Devuelve una referencia al vértice siguiente de éste en el polígono
     */
    public Vertice siguiente(){
        return null;
    }
    
    /**
     * Vertice anteriror del poĺigono
     * @return Devuelve una referencia al vertice anterior a éste en el polígono
     */
    public Vertice anterior(){
        return null;
    }
    
    /**
     * Vertice convexo
     * @return Devuelve True si es convexo o False si no lo es
     */
    publi bool convexo(){
        
    }
}
