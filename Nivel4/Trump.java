/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Item;
import Control.Nivel;
import java.util.Queue;

/**
 *
 * @author Luis Felipe Miranda
 */
public class Trump extends Item{
    public static final int height = 200, width = 200;
    public int index;
    private int life;
    
    public Trump(int x, int y, int width, int height, String spritePath, int frames, Nivel nivel){
        super(x, y, width, height, spritePath, frames, nivel);
        
        index = 0;
        life = 2000;
        
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    @Override
    public void tick() {
        boolean hit = false;
        Queue<Salsa> q = ((NivelCuatro)nivel).getBulletQueue();
        
        for(int i = q.size(); i > 0; i--){
            Salsa current = q.poll();
            
            if(intersects(current)){
                current.setDestroyed(true);
                hit = true;
                life = life - 50;
            }
            
            q.add(current);
            
        }
    }
    
}
