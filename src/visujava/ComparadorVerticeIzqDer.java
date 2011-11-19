/**
 * @Class ComparadorVerticeIzqDer.java
 * @Author José Manuel Serrano Mármol
 * @Author Raul Salazar de Torres
 * @Date 7-11-2011
 */
package visujava;
import java.util.*;

public class ComparadorVerticeIzqDer implements Comparator<Vertice>{
    @Override
      public int compare(Vertice a, Vertice b){
            if(a.leex() < b.leex()){
                return -1;
            }else{
                if(a.leex() > b.leex()){
                    return 1;
                }else{
                    if(a.leey() < b.leey()){
                        return -1;
                    }else{
                        if(a.leey() > b.leey()){
                            return 1;
                        }else{
                            return 0;
                        }
                    }
                }
            }
        }
}
