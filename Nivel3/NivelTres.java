/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel3;

import Control.Master;
import Control.Nivel;
import Control.Player;
import Nivel1.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelTres extends Control.Nivel implements Runnable{

    public NivelTres(Control.Display display, Player players[], Control.Master master) {
        
        super(display, master);
        this.players = new Player[4];
        int startX = 10;
        int startY = Nivel.height - Player.height*2;
        int separation = Player.width * 2;
        for (int i = 0; i < 4; i++) {
            
            this.players[i] = new Player_N3(players[i]);
            this.players[i].setX(startX + i*(players[i].getWidth() + separation));
            this.players[i].setY(startY);
        }
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

        for (int i = 0; i < 4; i++) {
            players[i].render(g);
        }
        /*
        g.drawImage(Control.Assets.background, getWidth()/5, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.pattern1, -400, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.pattern1, 800, 0, 600, getHeight(), null);
        g.drawImage(Control.Assets.catsup, 400, 350, 50, 50, null);*/
        
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        
    }
}
