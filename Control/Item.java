/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public abstract class Item {
    
    protected BufferedImage defaultImage;//In case render is not overrided in subclass
    protected Nivel nivel;
    protected int x, y, width, height;
    
    Item(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.defaultImage = defaultImage;
        this.nivel = game;
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(x, y, width, height);
    }
    
    boolean intersects(Item it){
        return getRectangle().intersects(it.getRectangle());
    }
    
    /**
     * Accesser to th default image
     * @return defaultImage
     */
    public BufferedImage getDefaultImage(){
        return defaultImage;
    }
    
    /**
     * Modifier for the Default Image
     * @param bi 
     */
    public void setDefaultImage(BufferedImage bi){
        defaultImage = bi;
    }
    
    /**
     * Unlike the inherited getX, it returns x 
     * @return x rounded
     */
    public int getX(){
        return x;
    }
    /**
     * Unlike the inherited getY, it returns y 
     * @return y rounded
     */
    public int getY(){
        return y;
    }
    /**
     * Unlike the inherited getWidth(), it returns width
     * @return width rounded
     */
    public int getWidth(){
        return width;
    }
    /**
     * Unlike the inherited getHeight, it returns height 
     * @return height rounded
     */
    public int getHeight(){
        return height;
    }
    /**
     * x modifier
     * @param x new value
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * y modifier
     * @param y new value
     */
    public void setY(int y){
        this.y = y;
    }
    
    public abstract void tick();
    
    public void render(Graphics g){
        g.drawImage(defaultImage, getX(), getY(), width, height, null);
    }
    
}
