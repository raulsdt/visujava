/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;
import java.util.*;
/**
 *
 * @author serrano
 */
public class ComparadorGrados implements Comparator<Vertice>{
    public static Punto minimo;
    
    @Override
     public int compare(Vertice a, Vertice b){        
        Punto min = new Punto(0, 0);
        System.out.println("A: "+"puntos("+a.x+" , "+ a.y +" ) " + min.angulo(a.lee()));
        System.out.println("B: " +"puntos("+b.x+" , "+ b.y +" ) " + min.angulo(b.lee()));
        System.out.println("-----------------------");
        
        if(min.angulo(a.lee()) < min.angulo(b.lee())){
            System.out.println("MIN"); 
            return -1; 
         }else{
             if(min.angulo(a.lee()) > min.angulo(b.lee())){
                 System.out.println("MAX");
                 return 1;
             }else{
                 return 0;
             }
         }
     }
}
