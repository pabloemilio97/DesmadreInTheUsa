/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel3;

import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Player_N3 extends Control.Player{
    
    public Player_N3(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
    }
    public boolean llegaALimiteSup(){
        if(this.y < 200){
            return true;
        }
        return false;
    }
    public boolean llegaALimiteInf(){
        if(this.y > this.getNivel().getHeight() - 200){
            return true;
        }
        return false;
    }
}
