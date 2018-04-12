package Control;

import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adanlopezalatorre
 */
public abstract class Nivel {
    private int lifestock;
    
    abstract int[] init();
    abstract  void tick();
    abstract void render(Graphics g);
    abstract void botonDeAccion(int num_player);
}

