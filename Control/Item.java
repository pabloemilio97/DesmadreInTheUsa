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
 * @author antoniomejorado
 */
public abstract class Item {
    protected int width;
    protected int height;
    protected int x;        // to store x position
    protected int y;        // to store y position
    protected BufferedImage defaultImage;
    protected Nivel nivel;
    
    /**
     * Set the initial values to create the item
     * @param x <b>x</b> position of the object
     * @param y <b>y</b> position of the object
     */
    public Item(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.defaultImage = defaultImage;
        this.nivel = game;
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
     * To paint the item
     * @param g <b>Graphics</b> object to paint the item
     */
    public void render(Graphics g){
        g.drawImage(defaultImage, x, y, width, height, null);
    }
    

    /**
     * Get x value
     * @return x 
     */
    public int getX() {
        return x;
    }

    /**
     * Get y value
     * @return y 
     */
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    /**
     * Set x value
     * @param x to modify
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y value
     * @param y to modify
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public boolean intersects(Object obj){
        return obj instanceof Item && 
        this.getBounds().intersects(((Item)obj).getBounds());
    }
    
    private Rectangle getBounds(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public Nivel getNivel() {
        return nivel;
    }
    
    /**
     * To update positions of the item for every tick
     */
    public abstract void tick();
}
