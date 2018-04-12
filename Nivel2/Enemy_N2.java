/*
ENEMY IN LEVEL TWO ADMINISTRATION CLASS GIVEN THE SPECIFIC GAME LEVEL MECHANICS
*/
package Nivel2;

import Control.Nivel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
    public Enemy_N2(int velocidad, int direccion, int x, int y, int width, 
            int height, BufferedImage defaultImage, Nivel nivel) {
        super(x, y, width, height, defaultImage, nivel);
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
