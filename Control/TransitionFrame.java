/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Assets.loadImage;
import static Control.Assets.loadSound;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

/**
 *
 * @author adanlopezalatorre
 */
public class TransitionFrame {
    private BufferedImage image;
    private SoundClip beginningSound;
    
    public TransitionFrame(String path){
        image = loadImage(path + ".png");
        beginningSound = new SoundClip(path + ".wav");
    }
    
    public void show(Graphics g){
        g.drawImage(image, 0, 0, Master.width, Master.height, null);
        beginningSound.play();
    } 
    
    public void stopSound(){
        beginningSound.stop();
    }
}
