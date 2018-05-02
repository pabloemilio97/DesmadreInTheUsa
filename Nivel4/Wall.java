/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Item;
import Control.Nivel;
import java.awt.image.BufferedImage;
import static java.lang.Math.PI;

/**
 *
 * @author Luis Felipe Miranda
 */
public class Wall extends Item{
    private int velocidad;
    private int degrees;
    private int type;

    public Wall(int x, int y, int width, int height, BufferedImage defaultImage, int type, Nivel game) {
        super(x, y, width, height, defaultImage, game);
        this.type = type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }
    
    public int getDegrees() {
        return degrees;
    }
    
    
    
    //Circular motion of the wall. Determine what happens with collision
    @Override
    public void tick() {
       if (type == 1){
           //destruir proyectil
       }
       
       if (type == 2){
           //dejar que pase
       }
       
       if (type == 3){
           //reflejarlo en otro
       }
    }
}