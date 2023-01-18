package Controlador;

import Modelo.Figura;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;

public class CntrlFigura {
    
    private Figura figura;
    
    public Color validarColor(String color){
        if(color.equalsIgnoreCase("amarillo")){
            return Color.YELLOW;
        }else if(color.equalsIgnoreCase("azul")){
            return Color.BLUE;
        }else if(color.equalsIgnoreCase("rojo")){
            return Color.RED;
        }else if(color.equalsIgnoreCase("verde")){
            return Color.GREEN;
        }else{
            JOptionPane.showMessageDialog(null, "El color \""+color+"\" no es un color valido.","Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public int convNum(String num){
        for (int i = 0; i < num.length(); i++) {
            if(Character.isLetter(num.charAt(i))){
                JOptionPane.showMessageDialog(null, "\""+num+"\" no es un numero valido.","Error", JOptionPane.ERROR_MESSAGE);
                return -99;
            }
        }
        return Integer.parseInt(num);
    }
    
    public Figura crearFigura(String color, String largo, String ancho, Point punto, String fig){
        Color col = validarColor(color);
        if(col!=null && convNum(largo)!=-99 && convNum(largo)!=-99){
            return new Figura(col, convNum(largo), convNum(ancho), punto, fig);
        }
        return null;
        
    }
}
