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
        int rad = 10;
        float angle = 50;

        this.x -= Math.round(rad * Math.cos(angle));
        this.y += Math.round(rad * Math.sin(angle));
        angle += .1;
    }
    
}
