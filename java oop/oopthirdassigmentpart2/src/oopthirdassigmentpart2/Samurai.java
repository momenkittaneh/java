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
public class Samurai extends Human {
    private
            static int counter=0;
    public
            Samurai(){
                this.health=200;
                counter++;
            }
            void deathBlow(Human h){
                h.health=0;
                int he = this.health;
                this.health-= (he*0.5);
            }
            void meditate(){
                this.health+= (this.health*0.5);
            }
            void howMany(){
                System.out.print(this.counter);
            }
}
