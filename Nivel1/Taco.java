/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Item;
import Control.Master;
import Control.Nivel;
import Control.Player;
import Control.SoundClip;
import java.awt.image.BufferedImage;
import java.util.Queue;

/**
 *
 * @author adanlopezalatorre
 */
public class Taco extends Item{
    private int velocidad; //velocidad del taco
    private int degrees, direction;
    private boolean inTransition, ready, destroyed;
    private SoundClip good;
    
    private static int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    /**
     * constructor for taco
     * @param x
     * @param y
     * @param width
     * @param height
     * @param path
     * @param frames
     * @param nivel 
     */
    public Taco(int x, int y, int width, int height, String path, int frames, Nivel nivel) {
        super(x, y, width, height, path, frames, nivel);
        degrees = direction = 0;
        inTransition = ready = destroyed = false;
        good = new SoundClip("/Sounds/good.wav");
    }
    
    /**
     * copy constructor
     * @param taco 
     */
    public Taco(Taco taco){
        super(taco.getX(), taco.getY(), taco.getWidth(), taco.getHeight(), null, taco.getGame());
        
        this.animation = taco.getAnimation();
        degrees = direction = 0;
        inTransition = ready = false;
    }
    
    /**
     * getter for taco destruction
     * @return 
     */
    public boolean isDestroyed(){
        return destroyed;
    }
    /**
     * tick handler for taco movement
     */
    @Override
    public void tick() {
        
        if(ready && x == 0 && y == 0){
            destroyed = true;
        }
        
        if(inTransition && renderCount + 1 == animation.length * Item.step){
            animation = ((NivelUno)nivel).getTacoReady().getAnimation();
            inTransition = false;
            ready = true;
        }
                
        if(x < 0 || y < 0 || x + width > Nivel.width || y + height > Nivel.height){
            direction = (direction + 1) % 4;
        }
        
        x = Math.max(0, x);
        x = Math.min(Nivel.width - width, x);
        y = Math.max(0, y);
        y = Math.min(Nivel.height - height, y);
        
        x += dirs[direction][0];
        y += dirs[direction][1];
        
        if(inTransition || ready) return;
        
        Queue<Salsa> bulletQueue = ((NivelUno)nivel).getBulletQueue();
        
        for(int i = bulletQueue.size(); i > 0; i--){
            Salsa current = bulletQueue.poll();
            
            if(intersects(current)){
                animation = ((NivelUno)nivel).getTacoTransition().getAnimation();
                inTransition = true;
                if(good != null) good.play();
                current.setDestroyed(true);
                
                int oldPuntaje = nivel.getPlayers()[current.getPlayerID()].getPuntaje();
            
                nivel.getPlayers()[current.getPlayerID()].setPuntaje(oldPuntaje + 100);
                
            }
            
            bulletQueue.add(current);
            
        }
        
    }
    
}
