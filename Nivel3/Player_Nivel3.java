/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel3;

/**
 *
 * @author pablo
 */
class Player_Nivel3 extends Control.Player{
    private int direccion;
    private int velocidad;
    
    public boolean colisiona(Obstaculo_Nivel3 obstaculo){
        return false;
    }
    public boolean llegaALimiteSup(){
        return false;
    }
    public boolean llegaALimiteInf(){
        return false;
    }
}
