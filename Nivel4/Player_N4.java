
/*
PLAYERS IN LEVEL FOUR SPECIFICATIONS AND ADMINISTRATION CLASS FOR THE PURPOSE OF GIVEN LEVEL GAME MECHANICS
*/
package Nivel4;

import Control.Nivel;
import Control.SoundClip;
import java.awt.image.BufferedImage;
import java.util.Queue;

/**
 *
 * @author adanlopezalatorre
 */
public class Player_N4 extends Control.Player{
    
    public Player_N4(int x, int y, int width, int height, String spritePath, int frames, Nivel game) {
        super(x, y, width, height, spritePath, frames, game);
    }
    public Player_N4(Control.Player player, Nivel miNivel){
        super(player, miNivel);
    }
    
    @Override
    public void tick(){
        Queue<Salsa> q = ((NivelCuatro)nivel).getBulletQueue();
        
        for(int i = q.size(); i > 0; i--){
            Salsa current = q.poll();
            
            if(current.isVenomous() && intersects(current)){
                current.setDestroyed(true);
                puntaje -= 100;
            }
            
            q.add(current);
        }
        
    }
    
}
