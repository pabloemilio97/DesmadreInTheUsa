package Control;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adanlopezalatorre
 */
public class Master implements KeyListener{
    Nivel []niveles; //Level array declaration
    Player[] players;
    public static int width = 1000, height = 700;
    public static int [] playerKeys = {KeyEvent.VK_Q, KeyEvent.VK_F, KeyEvent.VK_J, KeyEvent.VK_UP};
    public int currentNivel;
    public Display display;
    public Graphics g;
    
    public Master(){
        players = new Player[4];
        String []paths = {"Luchador/", "Mexicano/", "Frida/", "Calaca/"};
        
            
        for(int i = 0; i < 4; i++)
            players[i] = new Player(0, 0, Player.width, Player.height, "/Images/" + paths[i], 6, null);
        Assets.init();
        display = new Control.Display("Desmadre in the USA", Master.width, Master.height, this);
        //level's instantiation
        niveles = new Nivel[4];
        niveles[0] = new Nivel1.NivelUno(display, players, this);
        niveles[1] = new Nivel2.NivelDos(display, players, this);
        niveles[2] = new Nivel3.NivelTres(display, players, this);
        niveles[3] = new Nivel4.NivelCuatro(display, players, this);
        //CREATION OF PLAYERS
        currentNivel = -1;
    }
    
    public Display getDisplay(){
        return display;
    }
    
    public void nextGame(){
        if(currentNivel == 3){
            //handle end of game
            return;
        }
        
        niveles[++currentNivel].executeNivel();
    }

        //Key Typed method
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //KeyPreseed method
    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Key release method
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i = 0; i < 4; i++){
            if(niveles[currentNivel].isRunning() && key == Master.playerKeys[i]){
                niveles[currentNivel].botonDeAccion(i);
            }
        }
        if(key == KeyEvent.VK_SPACE){
            niveles[currentNivel].getTransition().nextTransition();
            
        }
    }
    
    public static void main(String [] args){
        Master mas = new Master();
        mas.nextGame();
    }
    
    /**
     * Regresa el numero de nivel para saber posicion
     * @return el numero del nivel en que se encuentra el juego
     */
    public int getNivel(){
        return currentNivel;
    }
}
