/**
 * @Class ComparadorGrados.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;
import java.util.*;

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
