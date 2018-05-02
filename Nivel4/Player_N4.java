/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Nivel;
import Control.SoundClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
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
    @Override
    public void tick() {
        
    }

}