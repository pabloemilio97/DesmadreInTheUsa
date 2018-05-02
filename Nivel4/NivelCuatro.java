/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import static Control.Assets.loadImage;
import Control.Nivel;
import Control.Player;
import Control.SoundClip;
import Control.Transition;
import Nivel1.Player_N1;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelCuatro extends Control.Nivel implements Runnable{
    
    private Guard [] wallArray;
    public static final int dirs[][] = {{-1, -1}, {1, -1}, {1, 1}, {-1, 1}};
    public Vector [] circlePoints;
    private Trump trump;
    private Queue<Salsa> bulletQueue;
    private Salsa salsaBullets[];
    
    public void setPositionArray(){
        circlePoints = new Vector[1000];
        
        circlePoints[0] = new Vector(0, Trump.height);
        
        double angle = Math.PI * 2 / circlePoints.length;
        
        double prevX = 0, prevY = Trump.height, curX, curY;
        
        double sin = Math.sin(angle), cos = Math.cos(angle);
        
        for(int i = 1; i < circlePoints.length; i++){
            curX = cos * prevX - sin * prevY;
            curY = sin * prevX + cos * prevY;
            
            circlePoints[i]= new Vector((int)Math.round(curX) - 20, (int)Math.round(curY) - 20);
            
            prevX = curX;
            prevY = curY; 
        }
        
    }
    
    public Queue getBulletQueue(){
        return bulletQueue;
    }
    
    public Salsa[] getSalsaBullets(){
        return salsaBullets;
    }
    
    public Guard[] getWallArray(){
        return wallArray;
    }
    
    public NivelCuatro(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        for(int i = 0; i < 4; i++)
            this.players[i] = new Player_N4(players[i], this);
        
        setPositionArray();
        wallArray = new Guard[20];
        for (int i = 0; i < wallArray.length; i++){
            
            if(i % 2 == 0){
                wallArray[i] = new Wall(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Wall/", 4, this);
            }
            else{
                wallArray[i] = new Reflector(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Reflect/", 2, this);
            }
            
            //wallArray[i] = new Wall(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Wall/", 4, this);
        }
        
        trump = new Trump((Nivel.width - Trump.width) / 2, (Nivel.height - Trump.height) / 2, Trump.width, Trump.height, "/Images/Trump/", 6, this);
        
        this.players[0].setX(0);
        this.players[0].setY(0);
        
        this.players[1].setX(Nivel.width - Player.width);
        this.players[1].setY(0);
        
        this.players[2].setX(Nivel.width - Player.width);
        this.players[2].setY(Nivel.height - Player.height);
        
        this.players[3].setX(0);
        this.players[3].setY(Nivel.height - Player.height);
        
        bulletQueue = new LinkedList<>();
        
        salsaBullets = new Salsa[4];
        
        for(int i = 0; i < 4; i++)
            salsaBullets[i] = new Salsa(this.players[i].getWidth() / 2 + this.players[i].getX() - Salsa.width / 2, this.players[i].getY(), Salsa.width, Salsa.height, "/Images/Bullet_Salsa/", 2, this, i);
        
    }
    /**
     * initializing	the	display	window	of	the	game
     */
    public int[] init() {
        //Control.Assets.init();
        running = true;
        music = new SoundClip("/Music/n4.wav");
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
        //keyManager.tick();
        //player.tick();
        trump.tick();
        for(int i = 0; i < wallArray.length; i++){
            if(!wallArray[i].isDestroyed()){
                wallArray[i].tick();
            }
        }
        
        for(int i = 0; i < 4; i++){
            players[i].tick();
        }
        
        for(int i = bulletQueue.size(); i > 0; i--){
            Salsa current = bulletQueue.poll();
            
            if(!current.isDestroyed())
                current.tick();
            if(!current.isDestroyed())
                bulletQueue.add(current);
        }
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
        trump.render(g);
        for(int i = 0; i < wallArray.length; i++){
            if(!wallArray[i].isDestroyed()){
                wallArray[i].render(g);
            }
        }
        for(int i = 0; i < 4; i++){
            players[i].render(g);
        }
        for(int i = bulletQueue.size(); i > 0; i--){
            Salsa current = bulletQueue.poll();
            
            current.render(g);
            
            bulletQueue.add(current);
            
        }
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        bulletQueue.add(new Salsa(salsaBullets[playerIndex]));
    }

    

    
    
}
