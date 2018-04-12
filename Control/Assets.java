package Control;

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
    
    public static BufferedImage background;

    /**
     * initializing	the	images	of	the	game
     */
    public static void init() {
        background = loadImage("/Images/Background.jpg");
    }
    
    public static Clip loadSound(String fileName){
        Clip collisionSound = null;
        try{
            collisionSound = AudioSystem.getClip();
            collisionSound.open(AudioSystem.getAudioInputStream(Assets.class.getResource("/Audio/" + fileName)));
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
    
    /**
     * to	get	an	image	from	the	file	path
     *
     * @param	path	it	is	the	path	of	the	file
     * @return	the	<bold>BufferedImage</bold>	object
     */
}
