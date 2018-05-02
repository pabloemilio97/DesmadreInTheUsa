/*
 * Manages methods and attributes common to all players
 */
package Control;

import static Control.Assets.loadImage;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Player extends Item{
    
    public static final int width = 50, height = 70;
    protected int puntaje;

    /**
     * constructor 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param spritePath
     * @param frames
     * @param game 
     */
    public Player(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {
        super(x, y, width, height, spritePath, frames, game);
        puntaje = 0;
    }
    
    
    /**
     * copy constructor
     * @param p
     * @param miNivel 
     */
    public Player(Player p, Nivel miNivel){
        super(p.x, p.y, p.getWidth(), p.getHeight(), null, miNivel);
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
    
    /**
     * manages tick of player, depending of each player
     */
    @Override
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
