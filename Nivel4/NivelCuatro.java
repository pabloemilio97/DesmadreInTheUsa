/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Player;
import Control.Transition;
import Nivel1.Player_N1;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelCuatro extends Control.Nivel implements Runnable{
    
    
    public NivelCuatro(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        for(int i = 0; i < 4; i++)
            this.players[i] = new Player_N4(players[i], this);
        
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
        //keyManager.tick();
        //player.tick();
    }
    
    @Override
    public void setTransition(){
        transition = new Transition("4", 5, display, this);
    }

    /**
     * Renders the actions based on the state of the player and the game
     */
    @Override
    public void render() {
        
        g.drawImage(Control.Assets.background, getWidth()/5, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.pattern1, -400, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.pattern1, 800, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.catsup, 400, 350, 50, 50, null);
        
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        
    }

    

    
    
}
