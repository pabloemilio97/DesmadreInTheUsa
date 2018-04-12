/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel2;

/**
 *
 * @author macuser
 */
public class Player_N2 extends Control.Player {

    private int posX;
    private int posY;
    private int velX;
    private int velY;

    public Player_N2() {
        this.velX = velX;
        this.velY = velY;
    }

    /**
     * para obtener velocidad x del jugador
     * @return vel x
     */
    public int getVelX() {
        return velX;
    }

    /**
     * para cambiar la velocidad x del jugador
     * @param velX 
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * para obtener velocidad y del jugador
     * @return velocidad y
     */
    public int getVelY() {
        return velY;
    }

    /**
     * para cambiar la velocidad y del jugador
     * @param velY 
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    
    
}
