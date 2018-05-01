/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author antoniomejorado
 */
public class Display {
    private JFrame jframe;  // this is the app class
    private Canvas canvas;  // to display images
    private Container scoreContainer, playerContainer[];
    private JLabel scoreLabels[];
    private static final int playerScoreHeight = Master.height / 5;
    
    private final String title;   // title of the window
    private final int width;      // width of the window
    private final int height;     // height of the window
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Container getScoreContainer(){
        return scoreContainer;
    }
    
    /**
     * initializes the values for the application game
     * @param title to display the title of the window
     * @param width to set the width
     * @param height to set the height
     */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;        
        createDisplay();
    }
    
    /**
     * create the app and the canvas and add the canvas to the window app
     */
    
    public Container getPlayerContainer(JLabel imageLabel){
        Container container = new Container();
        container.setPreferredSize(new Dimension(playerScoreHeight, playerScoreHeight));
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
                
        imageLabel.setSize(new Dimension(Master.width - Nivel.width, playerScoreHeight));
        
        container.add(imageLabel);
        
        return container;
    }
    
    public void createScoreContainer(){
        scoreContainer = new Container();
        scoreContainer.setPreferredSize(new Dimension(Master.width - Nivel.width, Nivel.height));
        scoreContainer.setLayout(new BoxLayout(scoreContainer, BoxLayout.Y_AXIS));
        
        playerContainer = new Container[4];
        scoreLabels = new JLabel[4];
        
        String traces[] = {"Calaca", "Frida", "Luchador", "Mexicano"};
        
        for(int i = 0; i < 4; i++){
            playerContainer[i] = getPlayerContainer(new JLabel(new ImageIcon("/Images/" + traces[i] + "/0.png")));
            
            scoreContainer.add(playerContainer[i]);
            
            Container labelContainer = new Container();
            labelContainer.setLayout(new FlowLayout());
            
            scoreLabels[i] = new JLabel("0");
            //labelContainer.add(scoreLabels[i]);
            
            playerContainer[i].add(labelContainer);
        }
        
    }
    
    public void createDisplay() {
        // create the app window
        jframe = new JFrame(title);
        
        // set the size of the window
        jframe.setSize(width, height);
        
        // setting not resizable, visible and possible to close
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        
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
