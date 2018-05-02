/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Item;
import Control.Nivel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Math.PI;

/**
 *
 * @author Luis Felipe Miranda
 */
public class Wall extends Item{
    private int velocidad;
    private int degrees;
    private int index;
    private int type;
    private int lives;
    Vector [] circlePoints;

    public Wall(int index, int width, int height, BufferedImage defaultImage, int type, Nivel game) {
        super(((NivelCuatro)game).circlePoints[index].x, ((NivelCuatro)game).circlePoints[index].y, width, height, defaultImage, game);
        this.type = type;
        this.index = index;
        this.circlePoints = ((NivelCuatro)game).circlePoints;
        lives = 4;
    }
    
    public Wall(int index, int width, int height, String path, int frames, Nivel game){
        super(((NivelCuatro)game).circlePoints[index].x, ((NivelCuatro)game).circlePoints[index].y, width, height, path, frames, game);
        this.type = type;
        this.index = index;
        this.circlePoints = ((NivelCuatro)game).circlePoints;
        lives = 4;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(animation[animation.length - lives], x, y, width, height, null);
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
       index = (index + 1) % circlePoints.length;
       
       x = Nivel.width / 2 + circlePoints[index].x;
       y = Nivel.height / 2 + circlePoints[index].y;
       
    }
}