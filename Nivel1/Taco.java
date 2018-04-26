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
import java.awt.image.BufferedImage;
import java.util.Queue;

/**
 *
 * @author adanlopezalatorre
 */
public class Taco extends Item{
    private int velocidad; //velocidad del taco
    private int degrees, direction;
    private boolean inTransition, ready;
    
    private static int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public Taco(int x, int y, int width, int height, String path, int frames, Nivel nivel) {
        super(x, y, width, height, path, frames, nivel);
        degrees = direction = 0;
        inTransition = ready = false;
    }
    
    
    @Override
    public void tick() {
        
        if(inTransition && renderCount + 1 == animation.length * 100){
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
                
                current.setDestroyed(true);
                
            }
            
            bulletQueue.add(current);
            
        }
        
        /*int rad = 200;       //Radius in px
        float angle = 0;     //Angle (this needs to be represented in radians, not degrees)
        float centerX = Master.width / 2;       //X Coordinate of the centre of rotation
        float centerY = Master.height / 2;       //Y Coordinate of the centre of rotation
        float time = 2;          //Number of seconds a full revolution should take
        int ticksPerSecond = 50; //Number of game updates per second

        float spriteX;       //X Position of sprite
        float spriteY;       //Y Position of sprite
        //Update the angle
        angle+= 2 * Math.PI / (ticksPerSecond * time);

        //Update the coordinates
        this.x = (int)(centerX  + (rad*Math.cos(angle)));
        this.y = (int)(centerY  + (rad*Math.sin(angle)));
        
        //If you want to set the initial angle of the object around the orbit-path, then simply specify in radians
        //angle = (angle in degrees)/180 * Math.PI
        */
    }
    
}
