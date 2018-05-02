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
import java.util.Queue;

/**
 *
 * @author adanlopezalatorre
 */
public class Player_N3 extends Control.Player{
    double xVel = 3;
    double yVel = 1;
    private int puntajeChoca = -10;
    private int distChoca = 150;
    private int prevTime;
    private SoundClip sonidoChoca;
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
        sonidoChoca = new SoundClip("/Sounds/oof.wav");
        prevTime = (int)System.currentTimeMillis();
    }
    /**
     * copy constructor
     * @param player 
     */
    public Player_N3(Control.Player player, Nivel miNivel){
        super(player, miNivel);
        sonidoChoca = new SoundClip("/Sounds/oof.wav");
        prevTime = (int)System.currentTimeMillis();
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
        if(((NivelTres)nivel).isReady()){
            //update yVel
            yVel = (llegaALimiteSup()) ? 0 : 1;
            //general advancement
            this.x += xVel;
            this.y -= yVel;   
            //collision with x limits
            if (x > Nivel.width - this.width || x < 0) {
                changeDirection();
            }
        }
                
        if (prevTime != nivel.getSeconds()) {
            //score management
            prevTime = nivel.getSeconds();
            int accumKey = 0; //0 is standard, 1 is negative, 2 is high
            if (llegaALimiteInf()) {
                accumKey = 1;
            }
            if (llegaALimiteSup()) {
                accumKey = 2;
            }
            this.acumPuntaje(((NivelTres) nivel).getAccums()[accumKey]);
        } 
        
        //collision with obstacles
        Queue<Obstaculo_N3> obstacleQueue = ((NivelTres) nivel).getObstacleQueue();

        for (int i = obstacleQueue.size(); i > 0; i--) {
            Obstaculo_N3 current = obstacleQueue.poll();
            if (intersects(current)) {
                sonidoChoca.play();
                current.setDestroyed(true);
                acumPuntaje(puntajeChoca);
                if(!llegaALimiteInf()){
                    if(y + distChoca > ((NivelTres)nivel).getLimiteInf()){
                        y = ((NivelTres)nivel).getLimiteInf();
                    }
                    else{
                        y += distChoca;
                    }
                }
            }
            obstacleQueue.add(current);
        }
    }
    
    /**
     * if player is moving right, now it moves left
     */
    public void changeDirection(){
        xVel *= -1;
    }
}

