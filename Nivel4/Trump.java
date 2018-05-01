/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

/**
 *
 * @author Luis Felipe Miranda
 */
public class Trump {
    public static final int height = 300, width = 300;
    public Vector circlePoints[];//0 is for x, 1 is for y
    
    public void setPositionArray(){
        circlePoints = new Vector[1000];
        
        circlePoints[0] = new Vector(0, Trump.height);
        
        double angle = Math.PI * 2 / circlePoints.length;
        
        double prevX = 0, prevY = Trump.height, curX, curY;
        
        for(int i = 1; i < circlePoints.length; i++){
            curX = Math.cos(angle) * prevX;
        }
        
    }
    
    public Trump(){
        
        
        
    }
    
}
