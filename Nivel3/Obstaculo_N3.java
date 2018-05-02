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
 * @author pablo
 */
class Obstaculo_N3 extends Control.Item{
    private int yVel;
    private boolean destroyed;
    
    /**
     * constructor for obstacle
     * @param x
     * @param y
     * @param width
     * @param height
     * @param path
     * @param frames
     * @param nivel 
     */
    public Obstaculo_N3(int x, int y, int width, int height, String path, int frames, Nivel nivel) {
        super(x, y, width, height, path, frames, nivel);
        yVel = 2;
        destroyed = false;
    }
    public Obstaculo_N3(Obstaculo_N3 obstaculo) {
        super(obstaculo.getX(), obstaculo.getY(), obstaculo.getWidth(), obstaculo.getHeight(), null, obstaculo.getGame());
        yVel = 2;
        this.setAnimation(obstaculo.getAnimation());
        destroyed = false;
    }
    
    /**
     * tick handler for obstacle movement
     */
    @Override
    public void tick() {
        if (((NivelTres) nivel).isReady()) {
            //general advancement
            this.y += yVel;
        }
        if(y > ((NivelTres) nivel).getLimiteInf()){
            destroyed = true;
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


