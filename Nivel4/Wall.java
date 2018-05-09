/*
 * Manages wall's actions on level 4
 */
package Nivel4;

import Control.Item;
import Control.Nivel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Math.PI;
import java.util.Queue;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Wall extends Guard{
        
    /**
     * constructor
     * @param index
     * @param width
     * @param height
     * @param path
     * @param frames
     * @param game 
     */
    public Wall(int index, int width, int height, String path, int frames, Nivel game){
        super(index, width, height, path, frames, game);
        this.index = index;
        this.circlePoints = ((NivelCuatro)game).circlePoints;
        lives = 4;
    }
    /**
     * sets wall's type
     * @param type 
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * gets the wall's type
     * @return 
     */
    public int getType() {
        return type;
    }
    
    /**
     * renders the wall
     * @param g 
     */
    @Override
    public void render(Graphics g){
        g.drawImage(animation[animation.length - lives], x, y, width, height, null);
    }
    
    /**
     * Circular motion of the wall. Determine what happens with collision
     */
     @Override
    public void tick() {
       index = (index + 1) % circlePoints.length;
       
       x = Nivel.width / 2 + circlePoints[index].x;
       y = Nivel.height / 2 + circlePoints[index].y;
       
       Queue<Salsa> q = ((NivelCuatro)nivel).getBulletQueue();
       
       boolean hit = false;
       for(int i = q.size(); i > 0; i--){
           Salsa current = q.poll();
           
           if(current != null && !current.isVenomous() && intersects(current)){
               current.setDestroyed(true);
               hit = true;
           }
           
           q.add(current);
       }
       if(hit){
           lives--;
           if(lives == 0) destroyed = true;
       }
       
    }
}