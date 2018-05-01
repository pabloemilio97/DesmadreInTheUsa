/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Assets.loadImage;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Player extends Item{
    
    public static final int width = 50, height = 70;
    int puntaje;

    public Player(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {
        super(x, y, width, height, spritePath, frames, game);
        puntaje = 0;
    }
    
    
    
    public Player(Player p){
        super(p.x, p.y, p.getWidth(), p.getHeight(), null, p.getNivel());
        animation = p.animation;
    }
    /**
     * Modifica el puntaje
     * @param puntaje nuevo valor
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    /**
     * suma al puntaje
     *
     * @param puntaje nuevo valor
     */
    public void acumPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }
    
    /**
     * Acceso a variable puntaje
     * @return el puntaje actual
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    @Override
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
