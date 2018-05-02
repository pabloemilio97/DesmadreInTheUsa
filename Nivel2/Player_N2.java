/*
 * Manages what the player does in level 2
 */
package Nivel2;

import Control.Nivel;
import Control.SoundClip;
import java.awt.image.BufferedImage;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Player_N2 extends Control.Player {

    private int velX;
    private int velY;

    /**
     * constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param spritePath
     * @param frames
     * @param game 
     */
    public Player_N2(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {
        super(x, y, width, height, spritePath, frames, game);
    }
    /**
     * copy constructor
     * @param player
     * @param miNivel 
     */
    public Player_N2(Control.Player player, Nivel miNivel){
        super(player, miNivel);
    }

    /**
     * para obtener velocidad x del jugador
     * @return vel x
     */
    public int getVelX() {
        return velX;
    }

    /**
     * para cambiar la velocidad x del jugador
     * @param velX 
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * para obtener velocidad y del jugador
     * @return velocidad y
     */
    public int getVelY() {
        return velY;
    }

    /**
     * para cambiar la velocidad y del jugador
     * @param velY 
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    
    /**
     * tick for player
     */
    @Override
    public void tick() {
        
        this.x += getVelX();
        this.y += getVelY();
    }
    
}
