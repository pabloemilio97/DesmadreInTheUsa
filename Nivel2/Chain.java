/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel2;
import Control.Item;
import Control.Nivel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author macuser
 */
public class Chain extends Control.Item{

    int velX;
    int velY;
    
    public Chain(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    
    @Override
    public void tick() {
        this.x += getVelX();
        this.y += getVelY();
    }
    
}
