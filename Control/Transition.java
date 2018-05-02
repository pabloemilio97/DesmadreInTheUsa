/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author adanlopezalatorre
 */
public class Transition {
    private TransitionFrame frames[];
    private Display display;
    private int currentFrame;
    Graphics g;
    BufferStrategy bs;
    private Nivel nivel;
    
    public Transition(String transNumber, int amount, Display display, Nivel nivel){
        frames = new TransitionFrame[amount];
        this.nivel = nivel;
        this.display = display;
        currentFrame = -1;
        
        for(int i = 1; i <= frames.length; i++){
            frames[i - 1] = new TransitionFrame("/Trans/Trans" + transNumber + "/"+ i);
        }
        
    }
    
    public void nextTransition(){
        
        //	get	the	buffer	strategy	from	the	display
        bs = display.getCanvas().getBufferStrategy();
        /*	if	it	is	null,	we	define	one	with	3	buffers	to	display	images	of
								the	game,	if	not	null,	then	we	display every	image	of	the	game	but
								after	clearing	the	Rectanlge,	getting	the	graphic	object	from	the	
								buffer	strategy	element.	
								show	the	graphic	and	dispose	it	to	the	trash	system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(2);
            bs = display.getCanvas().getBufferStrategy();
        }
        try{
        g = bs.getDrawGraphics();
        }catch(Exception e){
            return;
        }
            
        if(currentFrame != -1) frames[currentFrame].stopSound();
        
        if(currentFrame + 1 == frames.length){
            if(nivel != null)
                nivel.start();
            return;
        }
        else{
            frames[++currentFrame].show(g);
        }
        
        g.drawImage(Assets.spaceBar, 0, 0, 300, 50, null);
            
        bs.show();
        g.dispose();
    }
}
