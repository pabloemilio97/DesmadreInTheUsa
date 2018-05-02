/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel4;

import Control.Nivel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Queue;

/**
 *
 * @author adanlopezalatorre
 */
public class Reflector extends Guard{
    
    boolean reflection, revenge;
    public int [] keyIndices;
    public static int refCount = 500;
    private int reflectCountDown;

    public Reflector(int index, int width, int height, BufferedImage defaultImage, int type, Nivel game) {
        super(index, width, height, defaultImage, type, game);
    }
    public Reflector(int index, int width, int height, String path, int frames, Nivel game){
        super(index, width, height, path, frames, game);
        reflection = false;
        revenge = false;
        
    }
    
    boolean isReflection(){
        return reflection;
    }
    
    @Override
    public void tick() {
       index = (index + 1) % circlePoints.length;
       
       x = Nivel.width / 2 + circlePoints[index].x;
       y = Nivel.height / 2 + circlePoints[index].y;
       
       if(reflection) return;
       
       Queue<Salsa> q = ((NivelCuatro)nivel).getBulletQueue();
       
       for(int i = q.size(); i > 0; i--){
           Salsa current = q.poll();
           
           if(!current.isVenomous() && intersects(current)){
               reflection = true;
               current.setDestroyed(true);
               reflectCountDown = Reflector.refCount;
               revenge = true;
           }
           
           q.add(current);
           
       }
       
       if(revenge && Math.abs(circlePoints[index].x) == Math.abs(circlePoints[index].y)){
           Salsa [] array = ((NivelCuatro)nivel).getSalsaBullets();
           Salsa newBul = new Salsa(array[0]);
           
           int one = circlePoints[index].x / Math.abs(circlePoints[index].x), two = circlePoints[index].y / Math.abs(circlePoints[index].y);
                   
           for(int i = 0; i < 4; i++){
               if(NivelCuatro.dirs[i][0] == -one && NivelCuatro.dirs[i][1] == -two){
                   newBul.setPlayerID(i);
                   break;
               }
           }
           
           newBul.setX(x);
           newBul.setY(y);
           newBul.setVenomous(true);
           q.add(newBul);
           revenge = false;
       }
       
    }
    
    @Override
    public void render(Graphics g){
        if(reflection){
            g.drawImage(animation[1], x, y, width, height, null);
            if(reflectCountDown-- == 0){
                reflection = false;
            }
        }
        else{
            g.drawImage(animation[0], x, y, width, height, null);
        }
    }
    
    
    
    
}
