/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGeom;

import math.geom2d.Vector2D;


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

   //---------------------------- OPERACIONES
    
    /** 
     * Obtiene la longitud del vector actual
     * @return 
     */
    public double longitud () {
        return Math.sqrt(Math.pow(v.getX(),2) + Math.pow(v.getY(),2));
    }
    
    /**
     * Longitud del vector al cuadrado
     * @return 
     */
    public double longitud2(){
        return Math.pow(longitud(), 2);
    }
    
    /**
     * Vector perpendicualar
     * @return
     */
    public Vector perpendicular(){
        return new Vector(leey() * -1,leex());
    } 
    
    /**
     * Angulo que forma el vector
     * @return 
     */
    public double angulo (){
       return v.getAngle();   
    }    

    /** 
     * Suma al vector actual el vector v, devolviendo un nuevo vector con el resultado de la suma
     * @return 
     */
    public Vector suma (Vector v1) {
        return new Vector(v.plus(v1.v));
    }

    /** 
     * Resta al vector actual el vector v, devolviendo un nuevo vector con el resultado de la resta
     * @return 
     */
    public Vector resta (Vector v1) {
        return new Vector(v.minus(v1.v));
    }

    /** 
     * Obtiene un nuevo vector resultado del producto del vector actual por un escalar
     * @return 
     */
    public Vector prodEscalar (double t){
        return new Vector(v.times(t));
    }    

    
    /** Obtiene el producto escalar del vector actual con el vector v.
     * @return 
     */
    public double dot (Vector v1) {
        return v.dot(v1.v);
    }
    
    /** 
     * Obtiene el producto cruzado del vector actual con el vector v
     * @return 
     */
    public double kross (Vector v1) {
        return v.cross(v1.v);
    }

        
    /** 
     * Dice si el vector actual es ortogonal
     * @return 
     */
    public boolean ortogonal (Vector v1) {
        return v.isOrthogonal(v1.v);
    }

    /** 
     * Muestra por pantalla la información del vector actual. 
     */
    public void out () {
        String salida = v.toString();
        System.out.print (salida);
    }

    
}

    
    
    
    
