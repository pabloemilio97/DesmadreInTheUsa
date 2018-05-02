/*
 * Manages the display that is shown along the game, from window sizes to window partitions
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
 * @author 
 */
public class Display {
    private JFrame jframe;  // this is the app class
    private Canvas canvas, transitionCanvas, gameCanvas;  // to display images
    private JPanel scoreContainer;
    private Master master;
    private JLabel scoreLabels[], clockLabel, trumpLabel;
    private JPanel gamePanel, transitionPanel;
    private static final int playerScoreHeight = Master.height / 7;
    
    private final String title;   // title of the window
    private final int width;      // width of the window
    private final int height;     // height of the window
    
    /**
<<<<<<< HEAD
     * getter for width of window
     * @return int
=======
     * to get width of window
     * @return width
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public int getWidth(){
        return width;
    }
    /**
<<<<<<< HEAD
     * getter for height of window
     * @return int
=======
     * to get height of window
     * @return height
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public int getHeight(){
        return height;
    }
    /**
<<<<<<< HEAD
     * getter for the score labels
     * @return JLabel
=======
     * To get the labels that display score
     * @return score Labels
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
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
        createDisplay();
    }
    
    /**
<<<<<<< HEAD
     * changes the size of a given image, given its desired resolution
     * @param img
     * @param newW
     * @param newH
     * @return BufferedImage
=======
     * To be able to resize an image
     * @param img
     * @param newW
     * @param newH
     * @return 
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
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
    
    /**
<<<<<<< HEAD
     * Sets the minimum and maximum size, as well as the preferred size of an image
     * sets size
=======
     * To put a fixed size of an object
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     * @param cont
     * @param d 
     */
    private void fixSize(Component cont, Dimension d){
        cont.setMinimumSize(d);
        cont.setPreferredSize(d);
        cont.setMaximumSize(d);
    }
    
    /**
<<<<<<< HEAD
     * creates the score bar that appears to the right of the screen
=======
     * Creates the place where the score is displayed
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public void createScoreContainer(){
        scoreContainer = new Control.JPanel();
        fixSize(scoreContainer, new Dimension(Master.width - Nivel.width, Nivel.height));
        scoreContainer.setOpaque(false);
        scoreContainer.setLayout(new GridLayout(7, 1));
                
        scoreContainer.add(new JLabel());//new ImageIcon(loadImage("/Images/" + "scoreword"))));
        scoreLabels = new JLabel[4];
        
        String []paths = {"Luchador/", "Mexicano/", "Frida/", "Calaca/"};
        
        for(int i = 0; i < 4; i++){
                      
            Container current = new Container();
            current.setLayout(new GridLayout(1, 5));
            
            current.add(new Container());
            Icon myIcon = new ImageIcon(resize(loadImage("/Images/" + paths[i] + "0.png"), Player.width + 10, Player.height));
            
            JLabel imageLabel = new JLabel(myIcon);
            current.add(imageLabel);
            current.add(new Container());
            scoreLabels[i] = new JLabel("0");
            scoreLabels[i].setFont(new Font("TimesRoman", Font.BOLD, 20));
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
        
        trumpLabel = new JLabel("");
        trumpLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
        trumpLabel.setHorizontalAlignment(JLabel.CENTER);
        trumpLabel.setVerticalAlignment(JLabel.CENTER);
        scoreContainer.add(trumpLabel);
        
    }
    
    public JLabel getTrumpLabel(){
        return trumpLabel;
    }
    
    /**
<<<<<<< HEAD
     * resets the game display
=======
     * To set the display
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    void setGameDisplay(){        
        canvas = gameCanvas;
        jframe.setContentPane(gamePanel);
        jframe.pack();
        
    }
    
    /**
<<<<<<< HEAD
     * getter for the clock label
     * @return JLabel
=======
     * To create the label of time
     * @return 
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public JLabel getClockLabel(){
        return clockLabel;
    }
    
    /**
<<<<<<< HEAD
     * setter for the transition display
=======
     * Display for transition story frames
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    void setTransitionDisplay(){
        canvas = transitionCanvas;
        jframe.setContentPane(transitionPanel);
        jframe.pack();
    }
    
    /**
<<<<<<< HEAD
     * setter for the game's clock
=======
     * To change time of level
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     * @param seconds 
     */
    public void setClock(int seconds){
        int minutes = seconds / 60;
        seconds %= 60;
        
        clockLabel.setText("" + minutes / 10 + "" + minutes % 10 + ":" + seconds / 10 + "" + seconds % 10);
        
    }
    
    /**
<<<<<<< HEAD
     * creates the display that shows everything
=======
     * To create the display for game
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public void createDisplay(){
        jframe = new JFrame(title);
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        
        jframe.addKeyListener(master);
        
        jframe.setVisible(true);
        // set the size of the window
        transitionCanvas = new Canvas();
        transitionCanvas.setPreferredSize(new Dimension(Master.width, Master.height));
        transitionCanvas.setMaximumSize(new Dimension(Master.width, Nivel.height));
        transitionCanvas.setMinimumSize(new Dimension(Master.width, Master.height));
        transitionCanvas.setPreferredSize(new Dimension(Master.width, Master.height));
        transitionCanvas.setFocusable(false);
        
        transitionPanel = new JPanel();
        transitionPanel.add(transitionCanvas);
        
        gameCanvas = new Canvas();
        gameCanvas.setPreferredSize(new Dimension(Nivel.width, Nivel.height));
        gameCanvas.setMaximumSize(new Dimension(Nivel.width, Nivel.height));
        gameCanvas.setMinimumSize(new Dimension(Nivel.width, Nivel.height));
        gameCanvas.setPreferredSize(new Dimension(Nivel.width, Nivel.height));
        gameCanvas.setFocusable(false);
        
        gamePanel = new JPanel();
                
        createScoreContainer();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
        
        fixSize(gamePanel, new Dimension(Master.width, Master.height));
        
        gamePanel.add(gameCanvas);
        gamePanel.add(scoreContainer);
                        
    }
    
    /**
<<<<<<< HEAD
     * creates the transition display 
=======
     * creates a display for transition story frames
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public void createTransitionDisplay(){        
        
    }
    
    /**
<<<<<<< HEAD
     * creates the display specific to a level
=======
     * Creates display 
>>>>>>> aa80a9303178bbfac8894e86a950e6af53aeeddb
     */
    public void createGameDisplay() {
        
        gamePanel = new JPanel();
        
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
        fixSize(gamePanel, new Dimension(Master.width, Master.height));
                
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
        
        
        gamePanel.add(canvas);
        gamePanel.add(scoreContainer);
        
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
