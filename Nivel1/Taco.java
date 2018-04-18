/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Nivel;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Taco extends Control.Item{
    private int velocidad; //velocidad del taco
    private int degrees;
    
    public Taco(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
        degrees = 0;
    }
    
    protected Point getPointOnCircle(float degress, float radius) {

        int X = Math.round(getWidth() / 2);
        int Y = Math.round(getHeight() / 2);

        double rads = Math.toRadians(degress - 90); // 0 becomes the top

        // Calculate the outter point of the line
        int xPosy = Math.round((float) (X + Math.cos(rads) * radius));
        int yPosy = Math.round((float) (Y + Math.sin(rads) * radius));

        return new Point(xPosy, yPosy);

    }
    
    @Override
    public void tick() {
        
        int diameter = Math.min(getWidth(), getHeight());
        this.x = (getWidth() - diameter) / 2;
        this.y = (getHeight() - diameter) / 2;
        float innerDiameter = 20;

        Point p = getPointOnCircle(degrees, (diameter / 2f) - (innerDiameter / 2));
    }
    
}
