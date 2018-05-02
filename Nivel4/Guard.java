/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Item;
import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Guard extends Item{
    
    protected int type, index, lives;
    protected boolean destroyed;
    
    protected Vector [] circlePoints;
    
    /**
     * constructor
     * @param index
     * @param width
     * @param height
     * @param defaultImage
     * @param type
     * @param game 
     */
    public Guard(int index, int width, int height, BufferedImage defaultImage, int type, Nivel game) {
        super(((NivelCuatro)game).circlePoints[index].x, ((NivelCuatro)game).circlePoints[index].y, width, height, defaultImage, game);
        this.type = type;
        this.index = index;
        this.circlePoints = ((NivelCuatro)game).circlePoints;
        lives = 4;
        destroyed = false;
    }
    /**
     * constructor, but loads image with given path
     * @param index
     * @param width
     * @param height
     * @param path
     * @param frames
     * @param game 
     */
    public Guard(int index, int width, int height, String path, int frames, Nivel game){
        super(((NivelCuatro)game).circlePoints[index].x, ((NivelCuatro)game).circlePoints[index].y, width, height, path, frames, game);
        this.type = type;
        this.index = index;
        this.circlePoints = ((NivelCuatro)game).circlePoints;
        lives = 4;
        destroyed = false;
    }
    
    /**
     * gets the index
     * @return 
     */
    public int getIndex(){
        return index;
    }
    /**
     * sets the index
     * @param index 
     */
    public void setIndex(int index){
        this.index = index;
    }
    
    /**
     * getter for destroyed
     * @return 
     */
    boolean isDestroyed(){
        return destroyed;
    }
    
    /**
     * setter for destroyed
     * @param destroyed 
     */
    void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
    }

    /**
     * tick handler for guard
     */
    @Override
    public void tick() {
       index = (index + 1) % circlePoints.length;
       
       x = Nivel.width / 2 + circlePoints[index].x;
       y = Nivel.height / 2 + circlePoints[index].y;
       
    }
    
}
