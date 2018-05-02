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
    private int velX;
    private int velY;
    private boolean destroyed;

    /**
     * Constructor for enemy in level 2
     * @param velocidad
     * @param direccion
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public Enemy_N2(int x, int y, int width, 
            int height, BufferedImage defaultImage, Nivel nivel) {
        super(x, y, width, height, defaultImage, nivel);
        this.velX = 1;
        this.velY = 0;
    }
    
    /**
     * Para sacar la velocidad del enemigo
     * @return velocidadX
     */
    public int getVelX() {
        return velX;
    }

    /**
     * Para cambiar velocidad de enemigo
     * @param velocidad X
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }
    
        /**
     * Para sacar la velocidad y del enemigo
     * @return velocidadY
     */
    public int getVelY() {
        return velY;
    }

    /**
     * Para cambiar velocidad de enemigo
     * @param velocidad 
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    @Override
    public void tick() {
        this.y += velY;
        this.x += velX;
        
        if (getY() >= height+400){
            setX(-200);
            setVelX(2);
            setVelY(0);
        }
        if (getX() >= width+400){
            setY(-200);
            setVelY(1);
            setVelX(0);
        }
        if (getX() <= -400){
            setY(-200);
            setVelY(1);
            setVelX(0);
        }
        if (getY() <= -400){
            
        }
            
        }
        
    }
    
       /**
     * to determine if obstacle is destroyed
     * @return bool
     */
    public boolean isDestroyed() {
        return destroyed;
    }
    
    /**
     * to set obstacle to destroyed
     * @param destroyed 
     */
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
}
