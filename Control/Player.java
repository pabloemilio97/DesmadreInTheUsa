/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Player extends Item{
    
    int puntaje;

    public Player(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
        puntaje = 0;
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

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
