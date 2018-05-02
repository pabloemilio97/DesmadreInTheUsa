/*
 * Manages the attributes and methods common to all levels
 */
package Control;

import static Control.Assets.loadImage;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;


/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public abstract class Nivel implements Runnable{
    
    public static int width = 700, height = 700, nivelTime = 20;
    
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
    protected SoundClip music;
    
    /**
     * copy constructor
     * @param display
     * @param master 
     */    
    public Nivel(Display display, Control.Master master){
        this.display = display;
        this.master = master;
        this.players = new Player[4];
        running = false;
        setTransition();
        
    }
    
    /**
     * gets the transition for when game begins
     * @return 
     */
    public Transition getTransition(){
        return transition;
    }
    
    /**
     * will vary on each level
     */
    public abstract void setTransition();
    
    /**
     * runs a level
     */
    public void executeNivel(){
        display.createDisplay();
        display.setTransitionDisplay();
        transition.nextTransition();
    }
    
    /**
     * getter for running
     * @return 
     */
    public boolean isRunning(){
        return running;
    }
    
    /**
     * getter for endGame
     */
    public void endGame(){
        if(music != null){
            music.stop();
        }
        
        for(int i = 0; i < 4; i++){
            master.players[i].setPuntaje(this.players[i].getPuntaje());
        }
        
    }
    
    /**
     * sets fps of level, as wel as ticks
     */
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
    
    /**
     * gets the level's players
     * @return 
     */
    public Player[] getPlayers(){
        return players;
    }
    
    /**
     * setting	the	thread	for	the	game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            display.setGameDisplay();
            
            thread = new Thread(this);
            try{
            ///TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }
            thread.start();
            for(int i = 0; i < 4; i++){
                this.players[i].prepare();
            }
            endTime = Nivel.nivelTime * 1000 + System.currentTimeMillis();
        }
    }

    /**
     * stopping	the	thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                endGame();
                master.nextGame();
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            
            
        }
    }
    
    /**
     * get the width of level's display
     * @return 
     */
    public int getWidth(){
        return display.getWidth();
    }
    /**
     * get the height of level's display
     * @return 
     */
    public int getHeight(){
        return display.getHeight();
    }
    
    /**
     * get the end time
     * @return 
     */
    public long getEndTime() {
        return endTime;
    }
    
    /**
     * get the seconds that have elapsed since beginning of level
     * @return 
     */
    public int getSeconds(){
        return (int)(endTime - System.currentTimeMillis()) / 1000;
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
     * Renders the score of each player
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
    
    /**
     * renders the level's background
     */
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
            try{
            g = bs.getDrawGraphics();
            }catch(Exception e){
                return;
            }
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

