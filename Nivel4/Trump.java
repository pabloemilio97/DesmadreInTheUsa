/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Item;
import Control.Nivel;

/**
 *
 * @author Luis Felipe Miranda
 */
public class Trump extends Item{
    public static final int height = 200, width = 200;
    public int index;
    
    public Trump(int x, int y, int width, int height, String spritePath, int frames, Nivel nivel){
        super(x, y, width, height, spritePath, frames, nivel);
        
        index = 0;
        
    }

    @Override
    public void tick() {
        
        
    }
    
}
