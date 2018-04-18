
/*
PLAYERS IN LEVEL FOUR SPECIFICATIONS AND ADMINISTRATION CLASS FOR THE PURPOSE OF GIVEN LEVEL GAME MECHANICS
*/
package Nivel4;

import Control.Nivel;
import java.awt.image.BufferedImage;

/**
 *
 * @author adanlopezalatorre
 */
public class Player_N4 extends Control.Player{
    
    public Player_N4(int x, int y, int width, int height, BufferedImage defaultImage, Nivel game) {
        super(x, y, width, height, defaultImage, game);
    }
    public Player_N4(Control.Player player){
        super(player);
    }
    
}
