/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel3;

import Control.Master;
import Control.Nivel;
import Control.Player;
import Control.Transition;
import Nivel1.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import java.util.Queue;
import java.util.Random;
/**
 *
 * @author adanlopezalatorre
 */
public class NivelTres extends Control.Nivel implements Runnable{
    private int limiteSup;
    private int limiteInf;
    private boolean ready; //when true, players and obstacles move
    private long lastTime;
    private long prevTime; //controls how often players and objects move
    private final int accums[] = {5, -100, 15};
    private Queue<Obstaculo_N3> obstacleQueue;
    private int newObstacleCounter;
    private Obstaculo_N3 obstacle;
    private int randomTime = 3000;
    
    public NivelTres(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        //time related stuff
        ready = false;
        prevTime = System.currentTimeMillis(); //to handle time 
        
        //limits
        limiteSup = Player.height * 4;
        limiteInf = Nivel.height - Player.height * 2;
        
        //obstacles
        obstacleQueue = new LinkedList<>();
        newObstacleCounter = 0;
        
        int startY = Nivel.height - Player.height*2;
        int separation = Player.width * 2;
        int startX = Nivel.width - (Player.width + separation)*4;
        
        for (int i = 0; i < 4; i++) {
            this.players[i] = new Player_N3(players[i], this);
            this.players[i].setX(startX + i*(players[i].getWidth() + separation));
            this.players[i].setY(startY);
        }
        
        //initialize obstacle to be added to queue each time
        obstacle = new Obstaculo_N3(0, 0, Player.width, Player.height, "/Images/Taco_normal/", 2, this);
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
        long thisTime = System.currentTimeMillis();
        int timeDiff = (int)(thisTime - prevTime);
        if(timeDiff > 10){
            prevTime = thisTime;
            ready = true; //for moving players and obstacles
            newObstacleCounter++;
        }
        else{
            ready = false;
        }
        
        //players tick
        for(int i = 0; i < 4; i++){
           players[i].tick();   
        }
        
        //tick for obstacles
        for (int i = obstacleQueue.size(); i > 0; i--) {
            Obstaculo_N3 current = obstacleQueue.poll();

            current.tick();
            if (!current.isDestroyed()) {
                obstacleQueue.add(current);
            }
        }
        
        //generacion de cactus individuales
        int randValue = (int)(Math.random() * 300) + 1;
        if (newObstacleCounter % randValue == 0 && obstacleQueue.size() < 5) {
            int xRandom = (int) (Math.random() * (1000 - Player.width));
            obstacle.setX(xRandom);
            obstacleQueue.add(new Obstaculo_N3(obstacle));
            if(randValue % 2 == 0){
                newObstacleCounter = 1;
            }
        }
        /*
        long now = (endTime - System.currentTimeMillis()) / 1000;

        if (now != lastTime && now % 15 == 0) {
            randomTime /= 1.2;
        }
        lastTime = now;
        
        if (newObstacleCounter-- == 0) {
            int xRandom = (int)(Math.random() * (1000 - Player.width));
            obstacle.setX(xRandom);
            obstacleQueue.add(new Obstaculo_N3(obstacle));
            Random rand = new Random();
            newObstacleCounter = rand.nextInt(randomTime) + randomTime / 6;
        }
        */
    }
    @Override
    public void setTransition(){
        transition = new Transition("3", 7, display, this);
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

        for (int i = 0; i < 4; i++) {
            players[i].render(g);
        }
        for (int i = obstacleQueue.size(); i > 0; i--) {
            Obstaculo_N3 current = obstacleQueue.poll();
            current.render(g);
            obstacleQueue.add(current);
        }
    }
    
    /**
     * getter limite superior (coord Y)
     * @return 
     */
    public int getLimiteSup() {
        return limiteSup;
    }
    
    /**
     * getter limite inferior (coord Y)
     * @return 
     */
    public int getLimiteInf() {
        return limiteInf;
    }
    
    /**
     * getter for different values of accumulators for score
     * @return 
     */
    public int[] getAccums() {
        return accums;
    }
    
    /**
     * getter for when items are ready to move
     * @return  boolean
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * getter for queue of obstacles
     * @return Queue<Obstaculo_N3>
     */
    public Queue<Obstaculo_N3> getObstacleQueue() {
        return obstacleQueue;
    }
    
    
    @Override
    public void botonDeAccion(int playerIndex) {
        ((Player_N3)players[playerIndex]).changeDirection();
    }
}
