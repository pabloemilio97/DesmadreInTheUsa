/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author adanlopezalatorre
 */
public class Transition {
    private TransitionFrame frames[];
    
    public Transition(String transNumber){
        frames = new TransitionFrame[3];
        
        for(int i = 0; i < frames.length; i++){
            frames[i] = new TransitionFrame("/Trans/" + transNumber + i);
        }
        
    }
}
