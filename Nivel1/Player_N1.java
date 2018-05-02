/*
 * Manages players' actions for first level
 */
package Nivel1;

import Control.Nivel;
import Control.SoundClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Player_N1 extends Control.Player{
    /**
     * constructor for playerN1
     * @param x
     * @param y
     * @param width
     * @param height
     * @param spritePath
     * @param frames
     * @param game
     * @param actionSound 
     */
    public Player_N1(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {
        super(x, y, width, height, spritePath, frames, game);
    }
    /**
     * copy constructor
     * @param player 
     */
    public Player_N1(Control.Player player, Nivel miNivel){
        super(player, miNivel);
    }
    /**
     * tick for player
     */
    @Override
    public void tick() {
        
    }

}
