/**
 * @Class ComparadorArrAbaj.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;
import java.util.*;

public class ComparadorArrAbaj implements Comparator<Punto>{
    @Override
    public int compare(Punto a, Punto b){
        if(a.y < b.y){
            return 1;
        }else{
            if(a.y > b.y){
                return -1;
            }else{
                if(a.x < b.x){
                    return 1;
                }else{
                    if(a.x > b.x){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        }
    }
    
    
}
