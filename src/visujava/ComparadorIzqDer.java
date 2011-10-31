/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;
import java.util.*;
/**
 *
 * @author raul
 */
public class ComparadorIzqDer implements Comparator<Punto> {
    @Override
    public int compare(Punto a, Punto b){
        if(a.x < b.x){
            return -1;
        }else{
            if(a.x > b.x){
                return 1;
            }else{
                if(a.y < b.y){
                    return -1;
                }else{
                    if(a.y > b.y){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        }
    }
    
    
}
