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
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelCuatro extends Control.Nivel implements Runnable{
    
    private Wall [] wallArray;
    public static final int dirs[][] = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    public Vector [] circlePoints;
    private Trump trump;
    
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
    
    public Wall[] getWallArray(){
        return wallArray;
    }
    
    public NivelCuatro(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        for(int i = 0; i < 4; i++)
            this.players[i] = new Player_N4(players[i], this);
        
        setPositionArray();
        wallArray = new Wall[20];
        for (int i = 0; i < wallArray.length; i++){
            wallArray[i] = new Wall(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Wall/", 4, this);
        }
        
        trump = new Trump((Nivel.width - Trump.width) / 2, (Nivel.height - Trump.height) / 2, Trump.width, Trump.height, "/Images/Frida/", 1, this);
        
        this.players[0].setX(0);
        this.players[0].setY(0);
        
        this.players[1].setX(Nivel.width - Player.width);
        this.players[1].setY(0);
        
        this.players[2].setX(Nivel.width - Player.width);
        this.players[2].setY(Nivel.height - Player.height);
        
        this.players[3].setX(0);
        this.players[3].setY(Nivel.height - Player.height);
        
    }
    /**
     * initializing	the	display	window	of	the	game
     */
    public int[] init() {
        //Control.Assets.init();
        Wall o = wallArray[-1];
        running = true;
        SoundClip music = new SoundClip("/Music/n4.wav");
        music.setLooping(true);
        music.play();
        nivelTime = 120;
        wallArray = new Wall[20];
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
            wallArray[i].tick();
        }
        for(int i = 0; i < 4; i++){
            players[i].tick();
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
            wallArray[i].render(g);
        }
        for(int i = 0; i < 4; i++){
            players[i].render(g);
        }
    }

    @Override
    public void botonDeAccion(int playerIndex) {
        
    }

    

    
    
}
