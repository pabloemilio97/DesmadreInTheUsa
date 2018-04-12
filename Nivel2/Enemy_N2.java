/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel2;

import java.awt.Graphics;

/**
 *
 * @author macuser
 */
public class Enemy_N2 extends Control.Item{
    private int velocidad;
    private int direccion;

    /**
     * Constructor for enemy in level 2
     * @param velocidad
     * @param direccion
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public Enemy_N2(int velocidad, int direccion, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.velocidad = velocidad;
        this.direccion = direccion;
    }
    
    /**
     * Para sacar la velocidad del enemigo
     * @return velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Para cambiar velocidad de enemigo
     * @param velocidad 
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Para obtener direccion de enemigo
     * @return direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * Para cambiar direccion de enemigo
     * @param direccion 
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
