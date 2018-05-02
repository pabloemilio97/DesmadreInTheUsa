package Control;

import static Control.Assets.loadImage;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public abstract class Nivel implements Runnable{
    
    public static int width = 700, height = 700, nivelTime = 100;
    
    protected int lifestock;
    protected Display display;
    protected BufferStrategy bs;
    protected Graphics g;
    protected boolean running;
    protected long endTime;
    protected Thread thread;
    protected Control.Player players[];
    protected Control.Master master;
    protected Transition transition;
        
    public Nivel(Display display, Control.Master master){
        this.display = display;
        this.master = master;
        this.players = new Player[4];
        running = false;
        endTime = Nivel.nivelTime * 1000 + System.currentTimeMillis();
        setTransition();
        
    }
    
    public Transition getTransition(){
        return transition;
    }
    
    public abstract void setTransition();
    
    public void executeNivel(){
        display.createTransitionDisplay();
        transition.nextTransition();
        //start();
    }
    
    public boolean isRunning(){
        return running;
    }
    
    @Override
    public void run() {
        init();

        //frames per second
        int fps = 50;
        //time for each tick in nano secs
        double timeTick = ((int) 1e9) / fps;
        //initializing delta
        double delta = 0;
        //define now to use inside the loop
        long now, lastTime = System.nanoTime();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timeTick;
            lastTime = now;
            if (delta >= 1) {
                tick();
                gameRender();
                delta--;
            }
            tick();
            gameRender();
        }
        stop();
    }
    
    public Player[] getPlayers(){
        return players;
    }
    
    /**
     * setting	the	thread	for	the	game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            display.createGameDisplay();
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping	the	thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            
            master.nextGame();
            
        }
    }
    
    public int getWidth(){
        return display.getWidth();
    }
    public int getHeight(){
        return display.getHeight();
    }
    
    /**
     * init de cada nivel, regresa scores
     * @return int[] un arreglo con los scores de los jugadores al final del juego
     */
    public abstract int[] init();
    /**
     * tick de cada nivel
     */
    public abstract  void tick();
    /**
     * Renders the graphics of the game
     */
    
    
    
    private void renderScore(){
        
        
        JLabel [] labels = master.getDisplay().getScoreLabels();
        for(int i = 0; i < 4; i++){
            labels[i].setText(players[i].getPuntaje() + "");
        }
        
        master.getDisplay().setClock((int)(endTime - System.currentTimeMillis()) / 1000);
        
        /*int scoreHeight = Nivel.height / 5;
        
                
        for(int i = 0; i < 4; i++){
            g.drawImage(players[i].getAnimation(0), Nivel.width, i * scoreHeight, Player.width, Player.height, null);
            
            g.drawString("" + players[i].getPuntaje(), Nivel.width + Player.width + 60, i * scoreHeight + 60);
            
        }
        
        int cornerX = Nivel.width, cornerY = Nivel.height / 5 * 4;
        
        int centerX = (cornerX + Master.width) >> 1, centerY = (cornerY + Master.height) >> 1;
        
        long total = (endTime - System.currentTimeMillis()) / 1000;
        
        if(total == 0){
            stop();
            return;
        }
        
        long seconds = total % 60, minutes = total / 60;
        
        g.drawString(minutes + ":" + seconds, centerX - 20, centerY - 20);*/
        
    }
    
    protected void gameRender() {
        
        if((endTime - System.currentTimeMillis()) / 1000 < 0){
            stop();
            return;
        }
        
        //	get	the	buffer	strategy	from	the	display
        bs = display.getCanvas().getBufferStrategy();
        /*	if	it	is	null,	we	define	one	with	3	buffers	to	display	images	of
								the	game,	if	not	null,	then	we	display every	image	of	the	game	but
								after	clearing	the	Rectanlge,	getting	the	graphic	object	from	the	
								buffer	strategy	element.	
								show	the	graphic	and	dispose	it	to	the	trash	system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.backgrounds[master.currentNivel + 1], 0, 0, Master.width, Master.height, null);
            render();
            renderScore();
            
            bs.show();
            g.dispose();
        }
    }
    /**
     * render de cada nivel
     * @param g 
     */
    public abstract void render();
    /**
     * sirve para ecejutar accion de cada nivel, dependiendo del jugador que presiona
     * @param num_player 
     */
    public abstract void botonDeAccion(int playerIndex);
}

