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
    public static final int height = 300, width = 300;
    public int index;
    
    public Trump(int x, int y, int width, int height, String spritePath, int frames, Nivel nivel){
        super(x, y, width, height, spritePath, frames, nivel);
        
        index = 0;
        
    }

    @Override
    public void tick() {
        index = (index + 1) % (((NivelCuatro)nivel).circlePoints.length);
        
        x = Nivel.width / 2 + ((NivelCuatro)nivel).circlePoints[index].x;
        y = Nivel.height / 2 + ((NivelCuatro)nivel).circlePoints[index].y;
        
    }
    
}
