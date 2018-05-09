/*
 * Manages trump's actions on the game
 */
package Nivel4;

import Control.Item;
import Control.Nivel;
import java.util.Queue;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Trump extends Item{
    public static final int height = 200, width = 200;
    public int index;
    private int life;
    
    /**
     * constructor for trump
     * @param x
     * @param y
     * @param width
     * @param height
     * @param spritePath
     * @param frames
     * @param nivel 
     */
    public Trump(int x, int y, int width, int height, String spritePath, int frames, Nivel nivel){
        super(x, y, width, height, spritePath, frames, nivel);
        
        index = 0;
        life = 15000;
        
    }
    /**
     * changes trump's life
     * @param life 
     */
    public void setLife(int life) {
        //this.life = life;
    }
    
    /**
     * gets trump's life
     * @return 
     */
    public int getLife() {
        return life;
    }
    
    /**
     * tick for trump's actions
     */
    @Override
    public void tick() {
        boolean hit = false;
        Queue<Salsa> q = ((NivelCuatro)nivel).getBulletQueue();
        
        for(int i = q.size(); i > 0; i--){
            Salsa current = q.poll();
            
            if(current != null && intersects(current)){
                current.setDestroyed(true);
                hit = true;
                life = life - 50;
            }
            
            q.add(current);
            
        }
    }
    
}
