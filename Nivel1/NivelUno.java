/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author adanlopezalatorre
 */
public class NivelUno extends Control.Nivel implements Runnable{

    /*@Override
    public int[] init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void botonDeAccion(int num_player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/


    

    /**
     * to	create	title,	width	and	height	and	set	the	game	is	still	not	running
     *
     * @param	title	to	set	the	title	of	the	window
     * @param	width	to	set	the	width	of	the	window
     * @param	height	to	set	the	height	of	the	window
     */
    
    private BufferStrategy bs;		//	to	have	several	buffers	when	displaying
    private Graphics g;									//	to	paint	objects
    private Control.Display display;				//	to	display	in	the	game
    String title;															//	title	of	the	window
    private final int width;										//	width	of	the	window
    private final int height;									//	height	of	the	window
    private Thread thread;						//	thread	to	create	the	game
    private boolean running;				//	to	set	the	game
    
    private Control.Player player[];
    
    
    public NivelUno(String title, int width, int height) {

        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
    }
    
    
    /**
     * To access height of game screen
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * To access height of game screen
     *
     * @return height
     */
    public int getWidth() {
        return width;
    }
    /**
     * initializing	the	display	window	of	the	game
     */
    public int[] init() {
        display = new Control.Display(title, width, height);
        Control.Assets.init();
        running = true;
        /*
        Initialization of game characters should go here
         */
        display.getJframe().addKeyListener(new Control.Master());
        return new int[]{0, 0, 0, 0};
    }

    /**
     * Runs game until program is ordered otherwise.
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
                render();
                delta--;
            }
            tick();
            render();
        }
        stop();
    }

    /**
     * Updates graphics of game. It is called 50 times per second. All
     * characters inherit from class Item, so they all override their own tick
     * method, call them here
     */
    public void tick() {
        
        //keyManager.tick();
        //player.tick();

    }

    /**
     * Renders the graphics of the game
     */
    private void render() {
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
            gameRender();
            bs.show();
            g.dispose();
        }
    }

    /**
     * Renders the actions based on the state of the player and the game
     */
    public void gameRender() {
        g.drawImage(Control.Assets.background, width/5, 0, 600, height, null);
        g.drawImage(Control.Assets.pattern1, -400, 0, 600, height, null);
        g.drawImage(Control.Assets.pattern1, 800, 0, 600, height, null);
        g.drawImage(Control.Assets.catsup, 400, 350, 50, 50, null);
        
    }

    /**
     * setting	the	thread	for	the	game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
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
        }
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void botonDeAccion(Control.Player player) {
        System.out.println(player);
    }

    

    
    
}
