package Vista;

import Modelo.Figura;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
    private Figura figura;
    private boolean dibujar=false;
    
    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        if(dibujar){
            g.setColor(this.figura.getColor());
            if(figura.getFig().equals("Circulo")){
                g.fillOval(figura.getPunto().x-figura.getAncho(), figura.getPunto().y-figura.getAncho(), figura.getAncho()*2, figura.getAncho()*2);
            }else if (figura.getFig().equals("Cuadrado")) {
                g.fillRect(figura.getPunto().x-figura.getAncho()/2, figura.getPunto().y-figura.getAncho()/2, figura.getAncho(), figura.getAncho());
            }else if (figura.getFig().equals("Rectangulo")) {
                g.fillRect(figura.getPunto().x-figura.getAncho()/2, figura.getPunto().y-figura.getLargo()/2, figura.getAncho(), figura.getLargo());
            }else if (figura.getFig().equals("Triangulo")) {
                g.fillPolygon(dibujarTringulo());
            }else if (figura.getFig().equals("Estrella")) {
               g.fillPolygon(dibujarEstrella( figura.getPunto().x, figura.getPunto().y, figura.getAncho()));
            }
        }
        
    }
    
    public Polygon dibujarTringulo(){
        Polygon t = new Polygon();
        t.addPoint(figura.getPunto().x-(figura.getAncho()/2), figura.getPunto().y+(figura.getLargo()/2));
        t.addPoint(figura.getPunto().x+(figura.getAncho()/2), figura.getPunto().y+(figura.getLargo()/2));
        t.addPoint(figura.getPunto().x, figura.getPunto().y-(figura.getLargo()/2));
        return t;
    }
    
    
    public Polygon dibujarEstrella(int centrox, int centroy, double radio) {

        int puntos = 10;
        int[] polx = new int[puntos];
        int[] poly = new int[puntos];
        double radioInterno = radio*Math.sin(Math.toRadians(18)/Math.sin(Math.toRadians(54)));


        for (int i = 18; i < 360; i += 72) {
                polx[(i-18)/36] = centrox + (int) (radio * Math.cos(Math.toRadians(i)));
                poly[(i-18)/36] = centroy - (int) (radio * Math.sin(Math.toRadians(i))); 
        }

        for (int i = 54; i < 360; i += 72) {
                polx[(i-18)/36] = centrox + (int) (radioInterno * Math.cos(Math.toRadians(i)));
                poly[(i-18)/36] = centroy - (int) (radioInterno * Math.sin(Math.toRadians(i))); 
        }
        
        return new Polygon(polx, poly, puntos);

    }
    
    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
        this.dibujar=true;
        this.repaint();
    }

    public boolean isDibujar() {
        return dibujar;
    }

    public void setDibujar(boolean dibujar) {
        this.dibujar = dibujar;
        this.repaint();
    }
    
    
    
    
     
}
