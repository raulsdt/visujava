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
