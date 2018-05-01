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
    public Vector circlePoints[];//0 is for x, 1 is for y
    public int index;
    
    public void setPositionArray(){
        circlePoints = new Vector[10000];
        
        circlePoints[0] = new Vector(0, Trump.height);
        
        double angle = Math.PI * 2 / circlePoints.length;
        
        double prevX = 0, prevY = Trump.height, curX, curY;
        
        double sin = Math.sin(angle), cos = Math.cos(angle);
        
        for(int i = 1; i < circlePoints.length; i++){
            curX = cos * prevX - sin * prevY;
            curY = sin * prevX + cos * prevY;
            
            circlePoints[i]= new Vector((int)Math.round(curX), (int)Math.round(curY));
            
            prevX = curX;
            prevY = curY;
            
        }
        
    }
    
    public Trump(int x, int y, int width, int height, String spritePath, int frames, Nivel nivel){
        super(x, y, width, height, spritePath, frames, nivel);
        
        index = 0;
        
    }

    @Override
    public void tick() {
        index = (index + 1) % (circlePoints.length * Nivel.steps;
    }
    
}
