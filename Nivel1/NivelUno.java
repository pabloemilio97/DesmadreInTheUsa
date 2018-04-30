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
import Control.SoundClip;
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
    private long endTime, lastTime;
    private int randomTime = 3000;
    
    private Queue<Salsa> bulletQueue;
    private Queue<Taco> tacoQueue;
    private SoundClip actionSounds[] = new SoundClip[4];
    private String actionPaths[] = {"salsa1.wav", "salsa2.wav", "salsa3.wav", "salsa4.wav"};
    public NivelUno(Control.Display display, Control.Player players[], Control.Master master) {
        super(display, master);
        System.out.println(this.players);

        tacoTransition = new Taco(0, 0, 0, 0, "/Images/Taco_hit/", 4, this);
        tacoReady = new Taco(0, 0, 0, 0, "/Images/Taco_ready/", 7, this);
        for(int i = 0; i < 4; i++){
            this.players[i] = new Player_N1(players[i]);
            actionPaths[i] = "/Sounds/Salsa/" + actionPaths[i];
            actionSounds[i] = new SoundClip(actionPaths[i]);
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
        endTime = System.currentTimeMillis() + 15 * 1000;
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
     * Returns item that has the data for transitioning taco
     * @return 
     */
    public Item getTacoTransition(){
        return tacoTransition;
    }
    
    /**
     * returns the queue containing bullets
     * @return 
     */
    public Queue getBulletQueue(){
        return bulletQueue;
    }
    
    /**
     * returns item that has data for taco that is ready
     * @return 
     */
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
        
        long now = (endTime - System.currentTimeMillis()) / 1000;
        
        if(now != lastTime && now % 15 == 0){
            randomTime -= 500;
                        
            System.out.println(now + " " + randomTime);
            
        }
        lastTime = now;
        
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
        
        //display timer
        
        
        int cornerX = Nivel.width, cornerY = Nivel.height / 5 * 4;
        
        int centerX = (cornerX + Master.width) >> 1, centerY = (cornerY + Master.height) >> 1;
        
        long total = (endTime - System.currentTimeMillis()) / 1000;
        
        if(total == 0){
            stop();
            return;
        }
        
        long seconds = total % 60, minutes = total / 60;
        
        g.drawString(minutes + ":" + seconds, centerX - 20, centerY - 20);
        
    }
    /**
     * makes action for any player, which shoots salsa
     * @param playerIndex 
     */
    @Override
    public void botonDeAccion(int playerIndex) {
        bulletQueue.add(new Salsa(salsaBullets[playerIndex]));
        actionSounds[playerIndex].play();
    }

    

    
    
}
