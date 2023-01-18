/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import java.awt.Point;

public class Figura {
    private Color color;
    private int largo;
    private int ancho;
    private Point punto;
    private String fig;

    public Figura(Color color, int largo, int ancho, Point punto, String fig) {
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.punto = punto;
        this.fig = fig;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public Point getPunto() {
        return punto;
    }

    public void setPunto(Point punto) {
        this.punto = punto;
    }

    public String getFig() {
        return fig;
    }

    public void setFig(String fig) {
        this.fig = fig;
    }
    
    
}
