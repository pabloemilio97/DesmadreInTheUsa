/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel2;

import Control.Nivel;
import Control.Player;
import Control.SoundClip;
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
public class NivelDos extends Control.Nivel implements Runnable{    
    
    private static int centerSpace = 150;
    public static int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
        
    

    
    public NivelDos(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        for(int i = 0; i < 4; i++)
            this.players[i] = new Player_N2(players[i], this);
    }
    /**
     * initializing	the	display	window	of	the	game
     */
    public int[] init() {
        
        for(int i=0; i<4; i++){
            this.players[i] = new Player_N2(players[i], this);
            this.players[i].setX((Nivel.width - Player.width) / 2 + dirs[i][0] * centerSpace);
            this.players[i].setY((Nivel.height - Player.height) / 2 + dirs[i][1] * centerSpace);
        }
        
        //Control.Assets.init();
        running = true;
        SoundClip music = new SoundClip("/Music/n2.wav");
        music.setLooping(true);
        music.play();
        nivelTime = 120;
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
        for (int i=0; i<4; i++)
            players[i].tick();
        
        if (players[0].getY() >= height-100) {
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelY(-1);
        }
        if (players[2].getY() <= 0){
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelY(1);
        }
        if (players[1].getX() >= width-100) {
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelX(-1);
        }
        if (players[3].getX() <= 0){
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelX(1);                
        }
    }
    
    @Override
    public void setTransition(){
        transition = new Transition("2", 9, display, this);
    }

    /**
     * Renders the actions based on the state of the player and the game
     */
    @Override
    public void render() {
        for(int i = 0; i < 4; i++) players[i].render(g);
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        for(int i=0; i<4; i++){
            ((Player_N2)players[i]).setVelX(((Player_N2)players[i]).getVelX() + dirs[playerIndex][0]);
            ((Player_N2)players[i]).setVelY(((Player_N2)players[i]).getVelY() + dirs[playerIndex][1]);
        }
    }

    

    
    
}
