/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel2;

import static Control.Assets.loadImage;
import Control.Nivel;
import Control.Player;
import Control.SoundClip;
import Control.Transition;
import Nivel1.Player_N1;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelDos extends Control.Nivel implements Runnable{    
    
    private static int centerSpace = 150;
    public static int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private Queue<Enemy_N2> enemies;
    private Enemy_N2 enemy;
    
    private int enemyCount = 3;
    
    public NivelDos(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        for(int i = 0; i < 4; i++)
            this.players[i] = new Player_N2(players[i], this);
        
        //Initialize array list of enemies
        Random myRand = new Random();
        enemies = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            int randX = -myRand.nextInt(200);
            int randY = myRand.nextInt(height - Player.height);
            enemy = new Enemy_N2(0, 0, 50, 50, loadImage("/Images/snake.png"), this);
            enemy.setX(randX);
            enemy.setY(randY);
            enemies.add(enemy);
        }
        
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
     * Checks if the players collide with a wall
     */
    private void checkLimits(){
        
        if (players[0].getY() >= height-50) {
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelY(-1);
        }
        if (players[2].getY() <= 0){
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelY(1);
        }
        if (players[1].getX() >= width-50) {
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelX(-1);
        }
        if (players[3].getX() <= 0){
            for (int i=0; i<4; i++)
                ((Player_N2)players[i]).setVelX(1);                
        }
    }
    
    /**
     * Updates graphics of game. It is called 50 times per second. All
     * characters inherit from class Item, so they all override their own tick
     * method, call them here
     */
    public void tick() {
        
        for (int i=0; i<4; i++)
            players[i].tick();
        
        checkLimits();

        //tick for obstacles
        for (int i = 0; i < enemyCount; i++) {
            Enemy_N2 current = enemies.poll();
            current.tick();
            if(!current.isDestroyed()){
                enemies.add(current);
            }
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
        for (int i = 0; i < enemies.size(); i++) {
            Enemy_N2 current = enemies.poll();
            current.render(g);
            enemies.add(current);
        }
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        for(int i=0; i<4; i++){
            ((Player_N2)players[i]).setVelX(((Player_N2)players[i]).getVelX() + dirs[playerIndex][0]);
            ((Player_N2)players[i]).setVelY(((Player_N2)players[i]).getVelY() + dirs[playerIndex][1]);
        }
      
        
    }
    
    
}