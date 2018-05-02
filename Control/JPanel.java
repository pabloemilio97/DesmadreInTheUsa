/*
 * This class renders the score of each player
 */
package Control;

import static Control.Assets.loadImage;
import java.awt.Graphics;

/**
 * @author kevinradtke
 * @author felipemiranda
 * @author LuisMiranda97
 * @author pabloemilio97
 */
public class JPanel extends javax.swing.JPanel{

    /**
     * renders the game's score
     * @param g 
     */
   @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(loadImage("/Images/score.png"), 0, 0, null);
    }
}
