/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Nivel;
import Control.SoundClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
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
    public Player_N1(int x, int y, int width, int height, String spritePath, int frames, Nivel game, SoundClip actionSound) {
        super(x, y, width, height, spritePath, frames, game, actionSound);
    }
    /**
     * copy constructor
     * @param player 
     */
    public Player_N1(Control.Player player){
        super(player);
    }
    /**
     * tick for player
     */
    @Override
    public void tick() {
        
    }

}
