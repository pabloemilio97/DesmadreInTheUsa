/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Assets;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelUno extends Control.Nivel implements Runnable{

    private Control.Player player[];
    private Taco taco;
    
    
    public NivelUno(Control.Display display) {
        super(display);
        taco = new Taco(getWidth(), getHeight(), 50, 50, Assets.catsup, this);
    }
    /**
     * initializing	the	display	window	of	the	game
     */
    public int[] init() {
        //Control.Assets.init();
        running = true;
        /*
        Initialization of game characters should go here
         */
        return new int[]{0, 0, 0, 0};
    }
    /**
     * Updates graphics of game. It is called 50 times per second. All
     * characters inherit from class Item, so they all override their own tick
     * method, call them here
     */
    public void tick() {
        taco.tick();
        //keyManager.tick();
        //player.tick();
    }

    /**
     * Renders the actions based on the state of the player and the game
     */
    @Override
    public void render() {
        
        taco.render(g);
        
        g.drawImage(Control.Assets.background, getWidth()/5, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.pattern1, -400, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.pattern1, 800, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.catsup, 400, 350, 50, 50, null);
        
    }

    @Override
    public void botonDeAccion(Control.Player player) {
        
    }

    

    
    
}
