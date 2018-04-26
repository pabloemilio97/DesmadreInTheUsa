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
    SoundClip actionSound;

    public Player(int x, int y, int width, int height, String spritePath, int frames, Nivel game, SoundClip actionSound) {
        super(x, y, width, height, spritePath, frames, game);
        puntaje = 0;
        this.actionSound = actionSound;
    }
    
    
    
    public Player(Player p){
        super(p.x, p.y, p.getWidth(), p.getHeight(), null, p.getNivel());
        animation = p.animation;
        actionSound = p.actionSound;
    }
    /**
     * Modifica el puntaje
     * @param puntaje nuevo valor
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Acceso a variable puntaje
     * @return el puntaje actual
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * gets action sound
     * @return 
     */
    public SoundClip getActionSound() {
        return actionSound;
    }
    
    /**
     * Se reproduce el sonido respectivo
     */
    public void sonidoAccion(){
        this.actionSound.play();
    }

    @Override
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
