/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGeom;

import math.geom2d.Vector2D;

/**
 *
 * @author lidia
 */

public class Vector {
  Vector2D v;  

    private Vector (Vector2D vr){
        v = vr.clone();
    }    
  
    private Vector2D getVector2D (){
        return v;
    }
    
    /** Crea un vector con valores por defecto (componentes a 0). */
    public Vector() {
        v = new Vector2D();
    }

   /** Crea un vector dadas sus componentes iguales a xX y yY, 
   respectivamente. */
    public Vector (double xx,double yy) {
        v = new Vector2D(xx,yy);
    }

   /** Constructor copia */
    public Vector (Vector v1) {
        v = v1.v.clone();
    }

    
   /** Crea un vector dados los vectores v1 y v2 como v2-v1. */
    public Vector (Vector v1, Vector v2) {
        v = new Vector2D (v2.v.getX()-v1.v.getX(), v2.v.getY()-v1.v.getY());
    }

   
    /** Devuelve coordenada x */
    public double leex()  {
        return v.getX();
    }

    /** Devuelve coordenada y */
    public double leey()  {
        return v.getY();
    }

    
    /** Obtiene la longitud del vector actual. */
    public double longitud () {
        return Math.sqrt(Math.pow(v.getX(),2) + Math.pow(v.getY(),2));
    }

    public double angulo (){
       return v.getAngle();   
    }    

    /** Suma al vector actual el vector v, devolviendo un nuevo vector con 
     el resultado de la suma. */
    public Vector suma (Vector v1) {
        return new Vector(v.plus(v1.v));
    }

    /** Resta al vector actual el vector v, devolviendo un nuevo vector con 
     el resultado de la resta. */
    public Vector resta (Vector v1) {
        return new Vector(v.minus(v1.v));
    }

    /** Obtiene un nuevo vector resultado del producto del vector actual por un escalar*/
    public Vector prodEscalar (double t){
        return new Vector(v.times(t));
    }    

    
    /** Obtiene el producto escalar del vector actual con el vector v. */
    public double dot (Vector v1) {
        return v.dot(v1.v);
    }
    
    /** Obtiene el producto cruzado del vector actual con el vector v. */
    public double kross (Vector v1) {
        return v.cross(v1.v);
    }

        
    /** Dice si el vector actual es ortogonal  */
    public boolean ortogonal (Vector v1) {
        return v.isOrthogonal(v1.v);
    }

        /** Muestra por pantalla la información del vector actual. */
    public void out () {
        String salida = v.toString();
        System.out.print (salida);
    }

    
}

    
    
    
    
