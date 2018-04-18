/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 *
 * @author pablo
 */
public class Salsa extends Control.Item{
    private int velocidad; //velocidad del taco
    private int direccion; //arriba, abajo, izquierda o derecha dependiendo
                            //del jugador
    /**
     * receives as parameter an int representing the player that summons salsa
     * @param x
     * @param y
     * @param width
     * @param height
     * @param defaultImage
     * @param game
     * @param direccion 
     */
    public Salsa(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game, int direccion) {
        super(x, y, width, height, defaultImage, game);
        this.direccion = direccion; //se inicializa dependiendo del jugador
    }
    
    /**
     * gets velocity
     * @return int
     */
    public int getVelocidad() {
        return velocidad;
    }
    
    /**
     * sets velocity
     * @param velocidad int
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    /**
     * gets the direction the salsa is going to: up, down, right or left
     * @return 
     */
    public int getDireccion() {
        return direccion;
    }
    
    /**
     * sets direccion for salsa
     * @param x 
     */
    public void setDireccion(int x){
        this.direccion = x;
    }
    
    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
