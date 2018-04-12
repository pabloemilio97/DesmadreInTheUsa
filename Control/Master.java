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
    
    public void startGame(){
        
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
        System.out.println("ddd");
    }
    
}
