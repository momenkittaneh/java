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
public class Wizard extends Human {
    
    
    public
            Wizard(){
                int health=50;
                int intelligence =8;
            }
            void heal(Human h){
                h.health+=this.intelligence;
            }
            void fireball(Human h){
                h.health-= this.intelligence;
            }
    
}
