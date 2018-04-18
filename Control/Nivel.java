package Control;

import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public abstract class Nivel {
    private int lifestock;
    private int width;
    private int height;

    /**
     * getter para width
     * @return int width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * 
     * @return int height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * init de cada nivel, regresa scores
     * @return int[] un arreglo con los scores de los jugadores al final del juego
     */
    public abstract int[] init();
    /**
     * tick de cada nivel
     */
    public abstract  void tick();
    /**
     * render de cada nivel
     * @param g 
     */
    public abstract void render(Graphics g);
    /**
     * sirve para ecejutar accion de cada nivel, dependiendo del jugador que presiona
     * @param num_player 
     */
    public abstract void botonDeAccion(Player player);
}

