/*
 * this class controls how the levels and actions are handled
 */
package Control;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class Master implements KeyListener{
    Nivel []niveles; //Level array declaration
    Player[] players;
    public static int width = 1000, height = 700;
    public static int [] playerKeys = {KeyEvent.VK_Q, KeyEvent.VK_P, KeyEvent.VK_Z, KeyEvent.VK_M};
    public int currentNivel;
    public boolean won;
    public Display display;
    public Graphics g;
    private Transition end, lose;
    
    /**
     * constructor executed at beginning of game
     */
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
        won = false;
        end = new Transition ("X", 3, display, null);
    }
    
    /**
     * gets if someone has won
     * @return 
     */
    public boolean getWon(){
        return won;
    }
    /**
     * sets the winner
     * @param won 
     */
    public void setWon(boolean won){
        this.won = won;
    }
    
    /**
     * gets the global display
     * @return 
     */
    public Display getDisplay(){
        return display;
    }
    
    /**
     * executes levels by order
     */
    public void nextGame(){
        if(currentNivel == 3){
            if(won){
                currentNivel++;
                display.createDisplay();
                display.setTransitionDisplay();
                end.nextTransition();
            }
            
            else{
                currentNivel = -20;
                
                display.createDisplay();
                display.setTransitionDisplay();
                
                lose = new Transition("L", 1, display, null);
                lose.nextTransition();
                
            }
            
        }
        else {
            niveles[++currentNivel].executeNivel();
        }
    }

    /**
     * key typed method
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * key pressed method
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * key released method
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(currentNivel == -20) return;
        
        if(currentNivel == 4 || !niveles[currentNivel].isRunning()){
            if(key == KeyEvent.VK_SPACE){
                if(currentNivel == 4){
                    end.nextTransition();
                    
                    if(end.getCurrentFrame() == 1){
                        dispWinner();
                    }
                    
                }
                else{
                niveles[currentNivel].getTransition().nextTransition();
                }
            }
            return;
        }
        
        for(int i = 0; i < 4; i++){
            if(niveles[currentNivel].isRunning() && key == Master.playerKeys[i]){
                niveles[currentNivel].botonDeAccion(i);
            }
        }
    }
    /**
     * main class of the whole game
     * @param args 
     */
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
    void dispWinner(){
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(2);
            bs = display.getCanvas().getBufferStrategy();
        }
        Graphics g;
        try
        {
        g = bs.getDrawGraphics();
        }catch(Exception e){
            return;
        }
            
        
        
        g.drawImage(Assets.spaceBar, 0, 0, 300, 50, null);
        
        int whowon = 0;
        
        for(int i = 0; i < 4; i++){
            if(players[i].getPuntaje() > players[whowon].getPuntaje()){
                whowon = i;
            }
        }
        
        g.drawImage(players[whowon].getAnimation(0), 300, 200, 300, 300, null);
        
        bs.show();
        g.dispose();
    }
}
