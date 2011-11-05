/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visujava;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author serrano
 */
public class NubePuntos {

    protected int num;
    protected ArrayList<Punto> nube;

    /**
     * Controctor de la clase Nube, construye una nube de puntos aleatoria
     * @param n Número de puntos
     * @param semilla Semilla de inicialización aletoria
     */
    public NubePuntos(int n, int semilla) {
        nube = new ArrayList<Punto>();
        Random rnd = new Random(semilla);

        for (int i = 0; i < n; i++) {
            nube.add(new Punto(rnd.nextInt(Geometria.RANGO), rnd.nextInt(Geometria.RANGO)));
        }
        num = n;

    }
    
    /**
     * Constructor de la clase Nube, construye una nube a partir de otra
     * @param n Nube de puntos
     */
    public NubePuntos(NubePuntos n){
        nube = (ArrayList<Punto>) n.nube.clone();
        num = n.num;
    }
    
    /**
     * Constructor de la clase Nube, construye una nube de puntos desde un fichero
     * @param rutaFichero Ruta donde se encuentra el fichero de puntos
     */
    public NubePuntos(String rutaFichero) {
        
    }

    /**
     * Guarda un polígono en un fichero
     * @param p Poligono que se quiere guardar
     * @param ruta Ruta del fichero que se desea guardar
     */
    public void salvar(Poligono p, String ruta) {
        /*Vamos a crearlo en XML*/
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "xml", null);
            
            //VERSION 1.0
            document.setXmlVersion("1.0"); // asignamos la version de nuestro XML
            
            //RAIZ
            Element raiz = document.createElement("POLIGONO");  // creamos el elemento raiz
            document.getDocumentElement().appendChild(raiz);  //pegamos la raiz al documento
            
            for(int i = 0; i < p.numeroVertices(); i++){
                //Creamos elemento PUNTO
                Element elemento = document.createElement("PUNTO"); //creamos un nuevo punto
                
                //Creamos usus hijos (COORDENADAS)
                Element etiqX = document.createElement("X"); //creamos la coordenada X
                Element etiqY = document.createElement("Y"); //creamos la coordenada Y

                //Ponemos valos a las coordenadas
                Text coordX = document.createTextNode(Double.toString(p.lee(i).leex())); //Ingresamos la info (COORDENADA X)
                Text coordY = document.createTextNode(Double.toString(p.lee(i).leey())); //Ingresamos la info (COORDENADA X)
                
                raiz.appendChild(elemento); //pegamos el elemento PUNTO a la RAIZ <POLIGONO>
                
                //Hacemos las coordenadas hijas de PUNTO
                elemento.appendChild(etiqX);
                elemento.appendChild(etiqY);
                
                //Ponemos sus valores a las etiquetas X e Y
                etiqX.appendChild(coordX);
                etiqY.appendChild(coordY);
                
            }
            
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(ruta)); //nombre del archivo
//          Result console= new StreamResult(System.out); //Para mostrar por pantalla
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //Indentamos el XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);
//            transformer.transform(source, console); // Paramostrar por pantalla
            
            System.out.println("Archivo xml GENERADO!");

        }catch(Exception e){
            System.err.println("Error al crear XML: " + e);
        }
        
    }

    /**
     * Punto dada una posición
     * @param Posicion del punto iniciando en cero
     * @return Punto de la posición dada o null si no existe el punto
     */
    public Punto getPunto(int pos) {
        if (pos >= 0 && pos < num - 1) {
            return nube.get(pos);
        }
        return null;
    }

    /**
     * Caja que envuelve a toda la nube de puntos
     * @return Los punto que forman la caja envolvente
     */
    public Poligono cajaEnvolvente() {
        NubePuntos nubeX = new NubePuntos(ordenaXnube());
        NubePuntos nubeY = new NubePuntos(ordenaYnube());
        ArrayList<Vertice> Vertices = new ArrayList<Vertice>();
        
        //Metemos los vertices del cuadrilatero en sentido antihorario
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(0).leex(), nubeY.getPunto(0).leey())));
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(0).leex(), nubeY.getPunto(num-1).leey())));
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(num-1).leex(), nubeY.getPunto(num-1).leey())));
        Vertices.add(new Vertice(new Punto(nubeX.getPunto(num-1).leex(), nubeY.getPunto(0).leey())));
        
        return new Poligono(Vertices, 4);
    }

    /**
     * Punto central de la nube
     * @return El punto central o de masas
     */
    public Punto puntoCentral() {
        double sumX=0,sumY=0;
        for(int i=0;i<num;i++){
            sumX += nube.get(i).leex();
            sumY += nube.get(i).leey();
        }
        return new Punto(sumX/num, sumY/num);
    }
    
    /**
     * Punto centroide de una nube de puntos
     * @return El punto centroide de la nube de puntos
     */
    public Punto puntoCentroide() {
        //IMPLEMENTAR
        return null;
    }

    /**
     * Ordena la nube de puntos de izquierda a derecha
     */
    public void ordenaX() {
        Collections.sort(nube, new ComparadorIzqDer());
    }

    /**
     * Ordena la nube de puntos de izquierda a derecha en otra nube
     * @return Nube de puntos ordenada de izquierda a derecha
     */
    public NubePuntos ordenaXnube() {
        NubePuntos n = new NubePuntos(this);
        
        Collections.sort(n.nube, new ComparadorIzqDer());
        
        return n;
    }

    /**
     * Ordenar la nube de puntos de izquierda a derecha devolviendo las posiciones
     * @return Array de posiciones
     */
    public ArrayList<Integer> ordenaXindice() {
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        NubePuntos nubelo = new NubePuntos(ordenaXnube());
        
        for(int i=0;i< nubelo.num;i++){
            posiciones.add(nube.indexOf(nubelo.getPunto(i)));
        }
        return posiciones;
    }

    /**
     * Ordena la nube de puntos de arriba a abajo
     */
    public void ordenaY() {
        Collections.sort(nube, new ComparadorArrAbaj());
    }

    /**
     * Ordena la nube de puntos de arriba a abajo en otra nube
     * @return Nube de puntos ordenada de arriba a abajo
     */
    public NubePuntos ordenaYnube() {
        NubePuntos n = new NubePuntos(this);
        
        Collections.sort(nube, new ComparadorArrAbaj());
        
        return n;
    }

    /**
     * Ordenar la nube de puntos de arriba a abajo devolviendo las posiciones
     * @return Array de posiciones
     */
    public ArrayList<Integer> ordenaYindice() {
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        NubePuntos nubelo = new NubePuntos(ordenaYnube());
        
        for(int i=0;i< nubelo.num;i++){
            posiciones.add(nube.indexOf(nubelo.getPunto(i)));
        }
        return posiciones;
    }
}
