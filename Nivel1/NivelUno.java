/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Assets;
import Control.Master;
import Control.Player;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelUno extends Control.Nivel implements Runnable{

    private Taco taco;
    private static int centerSpace = 50;
    
    public NivelUno(Control.Display display, Control.Player players[]) {
        super(display);
        
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for(int i = 0; i < 4; i++){
            this.players[i] = new Player_N1(players[i]);
            
            this.players[i].setX((Master.width - Player.width) / 2 + dir[i][0] * centerSpace);
            this.players[i].setY((Master.height - Player.height) / 2 + dir[i][1] * centerSpace);
            
        }
        
        taco = new Taco(0, 0, Player.width, Player.height, "/Images/Taco_normal/", 2, this);
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
        System.out.println("ddd");
        taco.tick();
        //keyManager.tick();
        //player.tick();
    }

    /**
     * Renders the actions based on the state of the player and the game
     */
    @Override
    public void render() {
        if (g == null) {
            System.out.println("Error extraño");
            return;
        }
        g.drawImage(Control.Assets.background, 0, 0, Master.width, Master.height, null);
        //g.drawImage(Control.Assets.pattern1, -400, 0, 600, getHeight(), null);
        //g.drawImage(Control.Assets.pattern1, 800, 0, 600, getHeight(), null);
        taco.render(g);
        for(int i = 0; i < 4; i++) players[i].render(g);
        
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        
    }

    

    
    
}
