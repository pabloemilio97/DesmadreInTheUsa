/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 *
 * @author pablo
 */
public class Salsa extends Control.Item{
    private int velocidad; //velocidad del taco
    private int playerID; //controls direccion of salsa, and its color
    private boolean destroyed;
    public static final int width = 30, height = 30;
    /**
     * receives as parameter an int representing the player that summons salsa
     * @param x
     * @param y
     * @param width
     * @param height
     * @param defaultImage
     * @param game
     * @param playerID 
     */
    public Salsa(int x, int y, int width, int height, String path, int frames, Nivel nivel, int playerID){
        super(x, y, width, height, path, frames, nivel);
        destroyed = false;
        this.playerID = playerID;
    }
    public Salsa(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game, int playerID) {
        super(x, y, width, height, defaultImage, game);
        this.playerID = playerID; //se inicializa dependiendo del jugador
        destroyed = false;
    }
    
    public Salsa(Salsa salsa){
        super(salsa.getX(), salsa.getY(), salsa.getWidth(), salsa.getHeight(), null, salsa.getGame());
        this.playerID = salsa.getPlayerID();
        
        this.setAnimation(salsa.getAnimation());
        destroyed = false;
        
    }
    
    /**
     * gets velocity
     * @return int
     */
    public int getVelocidad() {
        return velocidad;
    }
    
    public boolean isDestroyed(){
        return destroyed;
    }
    public void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
    }
    
    /**
     * sets velocity
     * @param velocidad int
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    /**
     * gets the direction the salsa is going to: up, down, right or left
     * @return 
     */
    public int getPlayerID() {
        return playerID;
    }
    
    /**
     * sets direccion for salsa
     * @param x 
     */
    public void setPlayerID(int x){
        this.playerID = x;
    }
    
    @Override
    public void tick() {
        x += NivelUno.dirs[playerID][0];
        y += NivelUno.dirs[playerID][1];
        
        if(x < 0 || x + getWidth() > Nivel.width || y < 0 || y + this.getHeight() > Nivel.height){
            destroyed = true;
            
            int oldPuntaje = nivel.getPlayers()[playerID].getPuntaje();
            
            nivel.getPlayers()[playerID].setPuntaje(oldPuntaje - 100);
            
        }
                
    }
}
