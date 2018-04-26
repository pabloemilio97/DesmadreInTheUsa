/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Assets;
import static Control.Assets.loadImage;
import static Control.Assets.rotateImage;
import Control.Item;
import Control.Master;
import Control.Nivel;
import Control.Player;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelUno extends Control.Nivel implements Runnable{

    private Taco taco;
    private static int centerSpace = 50;
    public static int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private Salsa [] botes;
    private Salsa salsaBullets[];
    public Item tacoTransition, tacoReady;
    private int newTacoCounter;
    private long endTime;
    private static final int randomTime = 3000;
    
    private Queue<Salsa> bulletQueue;
    private Queue<Taco> tacoQueue;
    
    public NivelUno(Control.Display display, Control.Player players[]) {
        super(display);

        tacoTransition = new Taco(0, 0, 0, 0, "/Images/Taco_hit/", 4, this);
        tacoReady = new Taco(0, 0, 0, 0, "/Images/Taco_ready/", 7, this);
        
        for(int i = 0; i < 4; i++){
            this.players[i] = new Player_N1(players[i]);
            
            this.players[i].setX((Nivel.width - Player.width) / 2 + dirs[i][0] * centerSpace);
            this.players[i].setY((Nivel.height - Player.height) / 2 + dirs[i][1] * centerSpace);
            
        }
        
        salsaBullets = new Salsa[4];
        
        for(int i = 0; i < 4; i++)
            salsaBullets[i] = new Salsa(this.players[i].getWidth() / 2 + this.players[i].getX() - Salsa.width / 2, this.players[i].getY(), Salsa.width, Salsa.height, "/Images/Bullet_Salsa/", 2, this, i);
        
        //salsaBullets[0] = loadImage("/Images/Catsup.png)
        
        bulletQueue = new LinkedList<>();
        tacoQueue = new LinkedList<>();
        
        taco = new Taco(0, 0, Player.width, Player.height, "/Images/Taco_normal/", 2, this);
        
        newTacoCounter = 0;
        endTime = System.currentTimeMillis() + 90 * 1000;
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
    
    public Item getTacoTransition(){
        return tacoTransition;
    }
    
    public Queue getBulletQueue(){
        return bulletQueue;
    }
    
    public Item getTacoReady(){
        return tacoReady;
    }
    
    /**
     * Updates graphics of game. It is called 50 times per second. All
     * characters inherit from class Item, so they all override their own tick
     * method, call them here
     */
    public void tick() {
        
        for(int i = bulletQueue.size(); i > 0; i--){
            Salsa current = bulletQueue.poll();
                        
            current.tick();
            if(!current.isDestroyed())
                bulletQueue.add(current);
            
        }
        
        for(int i = tacoQueue.size(); i > 0; i--){
            Taco current = tacoQueue.poll();
            
            current.tick();
            
            if(!current.isDestroyed())
                tacoQueue.add(current);
            
        }
        
        
        if(newTacoCounter-- == 0){
            tacoQueue.add(new Taco(taco));
            
            Random rand = new Random();
            
            newTacoCounter = rand.nextInt(randomTime) + randomTime / 6;
            
        }
        
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
        
        
        for(int i = bulletQueue.size(); i > 0; i--){
            Salsa current = bulletQueue.poll();
            
            current.render(g);
            
            bulletQueue.add(current);
            
        }
        
        for(int i = tacoQueue.size(); i > 0; i--){
            Taco current = tacoQueue.poll();
            
            current.render(g);
            
            tacoQueue.add(current);
            
        }
        
        for(int i = 0; i < 4; i++) players[i].render(g);
        
        g.drawString("" + (endTime - System.currentTimeMillis()) / 1000, 500 + 20, Nivel.height / 5 * 4);
        
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        bulletQueue.add(new Salsa(salsaBullets[playerIndex]));        
    }

    

    
    
}
