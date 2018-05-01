package Control;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adanlopezalatorre
 */
public class Assets {

    static BufferedImage [] backgrounds;
    /**
     * initializing	the	images	of	the	game
     */
    public static void init() {
        backgrounds = new BufferedImage[4];
        for (int i=1; i<4; i++){
            backgrounds[i] = loadImage("/Images/BG" + i + ".png");
        }
    }
    
    public static Clip loadSound(String fileName){
        Clip collisionSound = null;
        try{
            collisionSound = AudioSystem.getClip();
            collisionSound.open(AudioSystem.getAudioInputStream(Assets.class.getResource(fileName)));
        }catch(Exception e){
            System.out.println(e.getClass());
            e.printStackTrace();
        }
        return collisionSound;
    }
    
    public static BufferedImage loadImage(String path) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(Assets.class.getResource(path));
        } catch (IOException ioe) {
            System.out.println("Error	loading	image	" + path + ioe.toString());
            System.exit(1);
        }
        return bi;
    }
    
    public static BufferedImage rotateImage(BufferedImage bufferedImage){
        AffineTransform tx = new AffineTransform();
        tx.rotate(0.5 * Math.PI, bufferedImage.getWidth() / 2.0, bufferedImage.getHeight() / 2.0);

        AffineTransformOp op = new AffineTransformOp(tx,
        AffineTransformOp.TYPE_BILINEAR);
        bufferedImage = op.filter(bufferedImage, null);
        
        return bufferedImage;
    }
    
    /**
     * to	get	an	image	from	the	file	path
     *
     * @param	path	it	is	the	path	of	the	file
     * @return	the	<bold>BufferedImage</bold>	object
     */
}
