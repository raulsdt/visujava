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
        if(minimo.angulo(a.lee()) < minimo.angulo(b.lee())){
            return -1; 
         }else{
             if(minimo.angulo(a.lee()) > minimo.angulo(b.lee())){
                 return 1;
             }else{
                 return 0;
             }
         }
     }
}
