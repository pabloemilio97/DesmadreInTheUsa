package Control;

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
    int [] playerKeys = {KeyEvent.VK_Q, KeyEvent.VK_F, KeyEvent.VK_H, KeyEvent.VK_UP};
    Nivel currentNivel;
    
    public void startGame(){
        currentNivel = new Nivel1.NivelUno("niv1", 400, 400);
        currentNivel.init();
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
        
    }
    
}
