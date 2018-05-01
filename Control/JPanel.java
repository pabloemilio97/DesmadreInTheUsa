/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Assets.loadImage;
import java.awt.Graphics;

/**
 *
 * @author adanlopezalatorre
 */
public class JPanel extends javax.swing.JPanel{

   @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(loadImage("/Images/FloorBG.png"), 0, 0, null);
    }
}
