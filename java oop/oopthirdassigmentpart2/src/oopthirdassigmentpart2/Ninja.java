/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopthirdassigmentpart2;

/**
 *
 * @author black
 */
public class Ninja extends Human {
    public
           Ninja(){
               int stealth= 10;
           }
           void steal(Human h){
               h.health-= this.stealth;
               this.health+= this.stealth;
           }
           void runaway(){
               this.health-=10;
           }
    
}
