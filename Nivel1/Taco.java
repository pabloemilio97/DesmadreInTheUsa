/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Taco extends Control.Item{
    private int velocidad; //velocidad del taco
    private int degrees;
    
    public Taco(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
        degrees = 0;
    }
    
    @Override
    public void tick() {
        int rad = 200;       //Radius in px
        float angle = 0;     //Angle (this needs to be represented in radians, not degrees)
        float centreX;       //X Coordinate of the centre of rotation
        float centreY;       //Y Coordinate of the centre of rotation
        float time = 2;          //Number of seconds a full revolution should take
        int ticksPerSecond = 50; //Number of game updates per second

        float spriteX;       //X Position of sprite
        float spriteY;       //Y Position of sprite
        //Update the angle
        angle+= 2 * Math.PI / (ticksPerSecond * time);

        //Update the coordinates
        spriteX = (centreX  + (rad*Math.cos(angle)));
        spriteY = (centreY  + (rad*Math.sin(angle)));
        
        //If you want to set the initial angle of the object around the orbit-path, then simply specify in radians
        angle = (angle in degrees)/180 * Math.PI
    }
    
}
