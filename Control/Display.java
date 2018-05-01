/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Assets.loadImage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author antoniomejorado
 */
public class Display {
    private JFrame jframe;  // this is the app class
    private Canvas canvas;  // to display images
    private JPanel scoreContainer;
    private Master master;
    private JLabel scoreLabels[], clockLabel;
    private static final int playerScoreHeight = Master.height / 7;
    
    private final String title;   // title of the window
    private final int width;      // width of the window
    private final int height;     // height of the window
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public JLabel[] getScoreLabels(){
        return scoreLabels;
    }
    
    
    
    /**
     * initializes the values for the application game
     * @param title to display the title of the window
     * @param width to set the width
     * @param height to set the height
     */
    public Display(String title, int width, int height, Master master) {
        this.title = title;
        this.master = master;
        this.width = width;
        this.height = height;        
    }
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
        Graphics2D g = dimg.createGraphics();  
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
        g.dispose();  
        return dimg;  
    }  
    
    private void fixSize(Component cont, Dimension d){
        cont.setMinimumSize(d);
        cont.setPreferredSize(d);
        cont.setMaximumSize(d);
    }
    
    public void createScoreContainer(){
        scoreContainer = new Control.JPanel();
        fixSize(scoreContainer, new Dimension(Master.width - Nivel.width, Nivel.height));
        scoreContainer.setOpaque(false);
        scoreContainer.setLayout(new GridLayout(6, 1));
                
        scoreContainer.add(new JLabel());//new ImageIcon(loadImage("/Images/" + "scoreword"))));
        scoreLabels = new JLabel[4];
        
        String traces[] = {"Calaca", "Frida", "Luchador", "Mexicano"};
        
        for(int i = 0; i < 4; i++){
                      
            Container current = new Container();
            current.setLayout(new GridLayout(1, 5));
            
            current.add(new Container());
            Icon myIcon = new ImageIcon(resize(loadImage("/Images/" + traces[i] + "/0.png"), Player.width + 10, Player.height));
            
            JLabel imageLabel = new JLabel(myIcon);
            current.add(imageLabel);
            current.add(new Container());
            scoreLabels[i] = new JLabel("0");
            scoreLabels[i].setFont(new Font("TimesRoman", Font.BOLD, 30));
            scoreLabels[i].setHorizontalAlignment(JLabel.CENTER);
            scoreLabels[i].setVerticalAlignment(JLabel.CENTER);
            
            current.add(scoreLabels[i]);
            current.add(new Container());
            scoreContainer.add(current);
            
        }
        
        clockLabel = new JLabel("00:00");
        clockLabel.setFont(new Font("TimesRoman", Font.BOLD, 30));
        clockLabel.setHorizontalAlignment(JLabel.CENTER);
        clockLabel.setVerticalAlignment(JLabel.CENTER);
        
        scoreContainer.add(clockLabel);
        
    }
    
    public JLabel getClockLabel(){
        return clockLabel;
    }
    
    public void setClock(int seconds){
        int minutes = seconds / 60;
        seconds %= 60;
        
        clockLabel.setText("" + minutes / 10 + "" + minutes % 10 + ":" + seconds / 10 + "" + seconds % 10);
        
    }
    
    public void createDisplay(){
        jframe = new JFrame(title);
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.addKeyListener(master);
        // set the size of the window
                
    }
    
    public void createTransitionDisplay(){
        if(jframe != null)jframe.setVisible(false);
        if(jframe != null) jframe.dispose();
        createDisplay();
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Master.width, Master.height));
        canvas.setMaximumSize(new Dimension(Master.width, Nivel.height));
        canvas.setMinimumSize(new Dimension(Master.width, Master.height));
        canvas.setPreferredSize(new Dimension(Master.width, Master.height));
        canvas.setFocusable(false);
        
        //jframe.removeAll();
        jframe.add(canvas);
        jframe.pack();
        
    }
    
    public void createGameDisplay() {
        
        if(jframe != null) jframe.setVisible(false);
        if(jframe != null) jframe.dispose();
        createDisplay();
        
        System.out.println("hii");
        jframe.setLayout(new BoxLayout(jframe.getContentPane(), BoxLayout.X_AXIS));
                
        // creating the canvas to paint and setting size
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Nivel.width, Nivel.height));
        canvas.setMaximumSize(new Dimension(Nivel.width, Nivel.height));
        canvas.setMinimumSize(new Dimension(Nivel.width, Nivel.height));
        canvas.setPreferredSize(new Dimension(Nivel.width, Nivel.height));
        canvas.setFocusable(false);
        
        createScoreContainer();
        
        // adding the canvas to the app window and packing to
        // get the right dimensions
        
        
        jframe.add(canvas);
        jframe.add(scoreContainer);
        jframe.pack();
    }

    /**
     * to get the jframe of the game
     * @return jframe
     */
    public JFrame getJframe() {
        return jframe;
    }
    
    /**
     * to get the canvas of the game
     * @return the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }
}
