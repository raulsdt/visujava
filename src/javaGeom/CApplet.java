/**
 * @author Jose Manuel Serrano
 * @author Raul Salazar
 * @date 17/11/11
 * @file CApplet.java
 */
package javaGeom;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import math.geom2d.Vector2D;
import visujava.Geometria;
import visujava.NubePuntos;
import visujava.Poligono;
import visujava.Punto;
import visujava.Recta;
import visujava.Vista;
import visujava.VisuNube;
import visujava.VisuPoligono;
import visujava.VisuPunto;

public class CApplet extends java.applet.Applet {

    public void init(Graphics g) {
    }

    /**pinta el eje de coordenadas en pantalla */
    private void ejesCoordenadas(Graphics g) throws Exception {
        g.setColor(Color.white);
        int ancho = Vista.ANCHO;
        int alto = Vista.ALTO;
        g.drawRect(0, 0, ancho, alto);
        g.fillRect(0, 0, ancho, alto);
        g.setColor(Color.gray);
        g.drawLine((int) (ancho / 2), 0, (int) (ancho / 2), alto); //línea vertical
        g.drawLine(0, (int) alto / 2, ancho, (int) alto / 2); //linea horizontal

        int medx = (int) (ancho / 2);
        int medy = (int) (alto / 2);

        int x = medx;
        while (x < ancho) {
            g.drawLine(x, medy - 2, x, medy + 2);
            g.drawLine(ancho - x, medy - 2, ancho - x, medy + 2);
            x += (int) (ancho * 10) / (2 * Geometria.RANGO);
        }
        int y = medy;
        while (y < alto) {
            g.drawLine(medx - 2, y, medx + 2, y);
            g.drawLine(medx - 2, alto - y, medx + 2, alto - y);
            y += (int) (alto * 10) / (2 * Geometria.RANGO);
        }

    }

    /** Modificar: meter aquí el código de prueba */
    private void pintar(Graphics g) throws Exception {
        Random r = new Random();

        //Elementos que intervienen (2 vectores, 2 rectas, 2 rayos, 2 segmentos)
        Vector v1 = new Vector(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO));
        Vector v2 = new Vector(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO));

        RectaPrm r1 = new RectaPrm(new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)), new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)));
        RectaPrm r2 = new RectaPrm(new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)), new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)));

        RayoPrm ra1 = new RayoPrm(new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)), new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)));
        RayoPrm ra2 = new RayoPrm(new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)), new Punto(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO)));

        SegmentoPrm se1 = new SegmentoPrm(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO));
        SegmentoPrm se2 = new SegmentoPrm(r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO), r.nextInt(Geometria.RANGO));

        //Posibles intersecciones
        ArrayList<Vista> vv = new ArrayList<Vista>();
        if (r1.intersecta(r2) != null) {
            Punto p = new Punto(r1.intersecta(r2));
            VisuPunto ppp = new VisuPunto(p);
            vv.add(ppp);
        }

        if (ra1.intersecta(ra2) != null) {
            Punto p1 = new Punto(ra1.intersecta(ra2));
            VisuPunto pp = new VisuPunto(p1);
            vv.add(pp);
        }
        if (ra1.intersecta(ra1) != null) {
            Punto p2 = new Punto(ra1.intersecta(ra1));
            VisuPunto pp1 = new VisuPunto(p2);
            vv.add(pp1);
        }
        if (ra1.intersecta(ra2) != null) {
            Punto p3 = new Punto(ra1.intersecta(ra2));
            VisuPunto pp2 = new VisuPunto(p3);
            vv.add(pp2);
        }
        if (se1.intersecta(ra1) != null) {
            Punto p4 = new Punto(se1.intersecta(ra1));
            VisuPunto pp3 = new VisuPunto(p4);
            vv.add(pp3);
        }
        if (se1.intersecta(ra2) != null) {
            Punto p5 = new Punto(se1.intersecta(ra2));
            VisuPunto pp4 = new VisuPunto(p5);
            vv.add(pp4);
        }
        if (se1.intersecta(r1) != null) {
            Punto p6 = new Punto(se1.intersecta(r1));
            VisuPunto pp5 = new VisuPunto(p6);
            vv.add(pp5);
        }
        if (se1.intersecta(r2) != null) {
            Punto p7 = new Punto(se1.intersecta(r2));
            VisuPunto pp6 = new VisuPunto(p7);
            vv.add(pp6);
        }
        if (se1.intersecta(se2) != null) {
            Punto p8 = new Punto(se1.intersecta(se2));
            VisuPunto pp7 = new VisuPunto(p8);
            vv.add(pp7);
        }

        //Creamos Visu y escribimos nombre de los elementos
        
        VisuVector vv1 = new VisuVector(v1);
        g.drawString("v1", (int) vv1.convCoordX(v1.leex()), (int) vv1.convCoordY(v1.leey()));
        VisuVector vv2 = new VisuVector(v2);
        g.drawString("v2", (int) vv2.convCoordX(v1.leex()), (int) vv2.convCoordY(v1.leey()));
        VisuRectaPrm vr1 = new VisuRectaPrm(r1);
        g.drawString("r1", (int) vr1.convCoordX(r1.r.getOrigin().x),
                (int) vr1.convCoordY(r1.r.getOrigin().y));
        VisuRectaPrm vr2 = new VisuRectaPrm(r2);
        g.drawString("r2", (int) vr2.convCoordX(r2.r.getOrigin().x),
                (int) vr2.convCoordY(r2.r.getOrigin().y));
        VisuRayoPrm vry = new VisuRayoPrm(ra1);
        g.drawString("y1", (int) vry.convCoordX(ra1.ry.getFirstPoint().x),
                (int) vry.convCoordY(ra1.ry.getFirstPoint().y));
        VisuRayoPrm vrz = new VisuRayoPrm(ra2);
        g.drawString("y2", (int) vrz.convCoordX(ra2.ry.getFirstPoint().x),
                (int) vrz.convCoordY(ra2.ry.getFirstPoint().y));
        VisuSegmentoPrm vrs = new VisuSegmentoPrm(se1);
        g.drawString("s1", (int) vrs.convCoordX(se1.s.getFirstPoint().x),
                (int) vrs.convCoordY(se1.s.getFirstPoint().y));
        VisuSegmentoPrm vrsz = new VisuSegmentoPrm(se2);
        g.drawString("s2", (int) vrsz.convCoordX(se2.s.getFirstPoint().x),
                (int) vrsz.convCoordY(se2.s.getFirstPoint().y));
        

        /** Definimos un array polimorfo */
        vv.add(vv1);
        vv.add(vv2);
        vv.add(vr1);
        vv.add(vr2);
        vv.add(vry);
        vv.add(vrz);
        vv.add(vrs);
        vv.add(vrsz);



        //Calcular 50 puntos aleatorios
        NubePuntos n = new NubePuntos(50, 24);
        VisuNube vsn = new VisuNube(n);
        Poligono poli = new Poligono(n.envolventeConvexa());
        VisuPoligono vpol = new VisuPoligono(poli);
        vv.add(vpol);
        vv.add(vsn);

        for (int i = 0; i < vv.size(); i++) {
            Vista obj = vv.get(i); //enganche polimorfo
            obj.pinta(g);     //ligadura dinámica
        }

    }

    @Override
    public void paint(Graphics g) {
        try {
            Rectangle r = g.getClipBounds();
            Vista.ALTO = (int) r.getHeight();
            Vista.ANCHO = (int) r.getWidth();
            ejesCoordenadas(g);
            pintar(g);

        } catch (Exception e) {
        }
    }
}
