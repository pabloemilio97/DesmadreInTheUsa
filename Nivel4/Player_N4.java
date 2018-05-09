/*
 * Manages players' actions in level 4
 */
package Nivel4;

import Control.Nivel;
import Control.Player;
import Control.SoundClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Queue;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Player_N4 extends Control.Player{
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
    public Player_N4(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {
        super(x, y, width, height, spritePath, frames, game);
    }
    /**
     * copy constructor
     * @param player 
     */
    public Player_N4(Control.Player player, Nivel miNivel){
        super(player, miNivel);
    }

    /**
     * tick for player
     */


    /**
     * player's tick, manages salsa shooting and reception
     */
    @Override
    public void tick(){
        Queue<Salsa> q = ((NivelCuatro)nivel).getBulletQueue();
        
        for(int i = q.size(); i > 0; i--){
            Salsa current = q.poll();
            
            if(current != null && current.isVenomous() && !current.isDestroyed() && intersects(current)){
                current.setDestroyed(true);
                puntaje -= 100;
            }
            
            q.add(current);
        }
        
    }
    
}

