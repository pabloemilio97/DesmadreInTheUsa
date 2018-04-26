/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel2;

import Control.Nivel;
import Control.SoundClip;
import java.awt.image.BufferedImage;

/**
 *
 * @author macuser
 */
public class Player_N2 extends Control.Player {

    private int velX;
    private int velY;

    public Player_N2(int x, int y, int width, int height, String spritePath, int frames, Nivel game, SoundClip actionSound) {
        super(x, y, width, height, spritePath, frames, game, actionSound);
    }
    public Player_N2(Control.Player player){
        super(player);
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
}
