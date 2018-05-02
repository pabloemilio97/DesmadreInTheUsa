/*
 * manages assets for transitions
 */
package Control;

import static Control.Assets.loadImage;
import static Control.Assets.loadSound;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class TransitionFrame {
    private BufferedImage image;
    private SoundClip beginningSound;
    
    /**
     * constructor
     * @param path 
     */
    public TransitionFrame(String path){
        image = loadImage(path + ".png");
        beginningSound = new SoundClip(path + ".wav");
    }
    
    /**
     * renders image
     * @param g 
     */
    public void show(Graphics g){
        g.drawImage(image, 0, 0, Master.width, Master.height, null);
        if (beginningSound!=null){
            beginningSound.play();
        }
        
    } 
    
    /**
     * stops the transition's sound when the next appears
     */
    public void stopSound(){
        if (beginningSound!=null){
            beginningSound.stop();
        }
    }
}
