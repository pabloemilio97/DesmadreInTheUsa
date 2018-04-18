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
    //com
    Nivel []niveles; //Level array declaration
    Player[] players;
    int [] playerKeys = {KeyEvent.VK_Q, KeyEvent.VK_F, KeyEvent.VK_J, KeyEvent.VK_UP};
    public Nivel currentNivel;
    public Display display;
    public Graphics g;
    
    public Master(){
        players = new Player[4];
        Assets.init();
        display = new Control.Display("Desmadre in the USA", 400, 400);
        display.getJframe().addKeyListener(this);
    }
    
    public void startGame(){
        currentNivel = new Nivel1.NivelUno(display);
    }
    public void runGame(){
        currentNivel.start();
        System.out.println("hello");
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
            if(key == playerKeys[i]){
                currentNivel.botonDeAccion(players[i]);
            }
        }
    }
    
    public static void main(String [] args){
        Master mas = new Master();
        mas.startGame();
        mas.runGame();
    }
    
}
