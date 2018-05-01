/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel3;

import Control.Master;
import Control.Nivel;
import Control.SoundClip;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Player_N3 extends Control.Player{
    int xVel = 10;
    int yVel = 10;
    /**
     * standard constructor 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param spritePath
     * @param frames
     * @param nivel 
     */
    public Player_N3(int x, int y, int width, int height, String spritePath, int frames, Nivel nivel) {
        super(x, y, width, height, spritePath, frames, nivel);
    }
    /**
     * copy constructor
     * @param player 
     */
    public Player_N3(Control.Player player){
        super(player);
    }
    /**
     * determines if superior limit of level is reached
     * @return 
     */
    public boolean llegaALimiteSup(){
        if (this.y <= ((NivelTres)nivel).getLimiteSup()){
            return true;
        }
        return false;
    }
    /**
     * determines if inferior limit of level is reached
     * @return 
     */
    public boolean llegaALimiteInf(){
        if(this.y >= ((NivelTres)nivel).getLimiteInf()){
            return true;
        }
        return false;
    }
    /**
     * actions to be made by player at all times
     */
    @Override
    public void tick() {
        //general advancement
        this.x += xVel;
        this.y += yVel;
        
        //collision with x limits
        if(x > Nivel.width || x < 0){
            xVel *= -1;
        }
        
        //score management
        int accumKey = 0; //0 is standard, 1 is negative, 2 is high
        if(y <= ((NivelTres)nivel).getLimiteInf()){
            yVel = 0;
            accumKey = 1;
        }
        if(y >= ((NivelTres)nivel).getLimiteSup()){
            yVel = 0;
            accumKey = 2;
        }
        this.acumPuntaje(((NivelTres)nivel).getAccums()[accumKey]);
    }
}
