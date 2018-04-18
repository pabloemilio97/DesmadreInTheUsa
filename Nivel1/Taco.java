/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Taco extends Control.Item{

    public Taco(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
