/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import static Control.Assets.loadImage;
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
    private int renderCount;
    protected Nivel nivel;
    BufferedImage animation[];
    
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
        animation = new BufferedImage[]{defaultImage};
        this.nivel = game;
        renderCount = 0;
    }
    
    public Item(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {     
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.nivel = game;
        renderCount = 0;
        animation = new BufferedImage[frames];
        for(int i = 0; i < frames; i++){
            animation[i] = loadImage(spritePath + i  + ".png");
        }
    }
        
    /**
     * To paint the item
     * @param g <b>Graphics</b> object to paint the item
     */
    public void render(Graphics g) {
        renderCount = (renderCount + 1) % (animation.length * 100);
        g.drawImage(animation[renderCount / 100], getX(), getY(), getWidth(), getHeight(), null);
    }
    

    /**
     * Get x value
     * @return x 
     */
    public int getX() {
        return x;
    }
    
    public BufferedImage getAnimation(int index){
        return animation[index];
    }
    
    public void setAnimation(int index, BufferedImage bi){
        animation[index] = bi;
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
