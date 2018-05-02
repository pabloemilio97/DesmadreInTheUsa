/*
ENEMY IN LEVEL TWO ADMINISTRATION CLASS GIVEN THE SPECIFIC GAME LEVEL MECHANICS
*/
package Nivel2;

import Control.Nivel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Enemy_N2 extends Control.Item{
    private int velX;
    private int velY;
    private int speed = 1;
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
     * to change speed of enemies
     * @param sp speed
     */
    public void setSpeed(int sp){
        speed = sp;
    }
    
    /**
     * to get speed from nivel
     * @return 
     */
    public int getSpeed(){
        return speed;
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

    /**
     * tick for enemy on second level
     */
    @Override
    public void tick() {
        this.y += velY;
        this.x += velX;
        
        if (getY() >= nivel.height+100){
            Random myRand = new Random();
            setX(nivel.getWidth()+myRand.nextInt(200));
            setY(myRand.nextInt(nivel.getHeight()-100));
            setVelX(-speed);
            setVelY(0);
        }
        if (getX() >= nivel.width+100){
            Random myRand = new Random();
            setX(myRand.nextInt(nivel.getWidth()-100));
            setY(-myRand.nextInt(200));
            setVelY(speed);
            setVelX(0);
        }
        if (getX() <= -100){
            Random myRand = new Random();
            setX(myRand.nextInt(nivel.getWidth()-100));
            setY(nivel.getHeight()+myRand.nextInt(200));
            setVelY(-speed);
            setVelX(0);
        }
        if (getY() <= -100){
            Random myRand = new Random();
            setX(-myRand.nextInt(200));
            setY(myRand.nextInt(nivel.getHeight()-100));
            setVelX(speed);
            setVelY(0);
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
