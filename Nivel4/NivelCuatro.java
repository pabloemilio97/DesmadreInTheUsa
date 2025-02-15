/*
 * Manages all actions in level 4
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
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class NivelCuatro extends Control.Nivel implements Runnable{
    
    private Guard [] wallArray;
    public static final int dirs[][] = {{-1, -1}, {1, -1}, {1, 1}, {-1, 1}};
    public Vector [] circlePoints;
    private Trump trump;
    private Queue<Salsa> bulletQueue;
    private Salsa salsaBullets[];
    
    /**
     * creates array with positions for circular motion
     */
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
    /**
     * gets the bullet queue of enemy
     * @return 
     */
    public Queue getBulletQueue(){
        return bulletQueue;
    }
    /**
     * gets the salsa bullets
     * @return 
     */
    public Salsa[] getSalsaBullets(){
        return salsaBullets;
    }
    /**
     * gets wall array
     * @return 
     */
    public Guard[] getWallArray(){
        return wallArray;
    }
    /**
     * constructor
     * @param display
     * @param players
     * @param master 
     */
    public NivelCuatro(Control.Display display, Player players[], Control.Master master) {
        super(display, master);
        
        for(int i = 0; i < 4; i++)
            this.players[i] = new Player_N4(players[i], this);
        
        setPositionArray();
        wallArray = new Guard[20];
        for (int i = 0; i < wallArray.length; i++){
            
            if(i % 4 != 0){
                wallArray[i] = new Wall(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Wall/", 4, this);
            }
            else{
                wallArray[i] = new Reflector(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Reflect/", 2, this);
            }
            
            //wallArray[i] = new Wall(circlePoints.length / wallArray.length * i, 50, 50, "/Images/Wall/", 4, this);
        }
        
        trump = new Trump((Nivel.width - Trump.width) / 2, (Nivel.height - Trump.height) / 2, Trump.width, Trump.height, "/Images/Trump/", 2, this);
        
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
        if(trump.getLife() <= 0){
           master.setWon(true);
           stop();
           return;
        }
        
        
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
            
            if(current != null && !current.isDestroyed())
                current.tick();
            if(current != null && !current.isDestroyed())
                bulletQueue.add(current);
        }
    }
    
    /**
     * changes transition to be played before level
     */
    @Override
    public void setTransition(){
        transition = new Transition("4", 6, display, this);
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
            
            if(current != null)current.render(g);
            
            bulletQueue.add(current);
        }
        //g.drawString(String.valueOf(trump.getLife()), width/2 - 25, height/2 + 100);
        
        master.getDisplay().getTrumpLabel().setText("Enemy's life: " + trump.getLife());
        
    }

    /**
     * determines what each player's action button does (shoot)
     * @param playerIndex 
     */
    @Override
    public void botonDeAccion(int playerIndex) {
        bulletQueue.add(new Salsa(salsaBullets[playerIndex]));
    }

    

    
    
}
