/*
 * Manages the chain's actions on second level
 */
package Nivel2;
import Control.Item;
import Control.Nivel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Chain extends Control.Item{

    int velX;
    int velY;
    
    /**
     * constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param defaultImage
     * @param game 
     */
    public Chain(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
    }

    /**
     * gets x velocity
     * @return int
     */
    public int getVelX() {
        return velX;
    }
    
    /**
     * gets y velocity
     * @return int
     */
    public int getVelY() {
        return velY;
    }

    /**
     * sets x velocity in x
     * @param velX 
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * sets y velocity
     * @param velY 
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * tick of the chain
     */
    @Override
    public void tick() {
        this.x += getVelX();
        this.y += getVelY();
    }
    
}
