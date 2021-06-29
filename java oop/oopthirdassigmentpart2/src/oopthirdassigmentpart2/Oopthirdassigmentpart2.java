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
public class Oopthirdassigmentpart2 {
//class Human {
//    private
//           int strength= 3;
//           int stealth=3;
//           int intelligence =3;
//           int health = 100;
//    public
//           void attack(Human h1){
//               this.health-= h1.strength;
//               System.out.print(health);
//           }
//}
//class Ninja extends Human {
//    public
//           Ninja(){
//               int stealth= 10;
//           }
//           void steal(Human h){
//               h.health-= this.stealth;
//               this.health+= this.stealth;
//           }
//           void runaway(){
//               this.health-=10;
//           }
//    
//}
//class Samurai extends Human {
//     private
//            static int counter=0;
//    public
//            Samurai(){
//                this.health=200;
//                counter++;
//            }
//            void deathBlow(Human h){
//                h.health=0;
//                int he = this.health;
//                this.health-= (he*0.5);
//            }
//            void meditate(){
//                this.health+= (this.health*0.5);
//            }
//            void howMany(){
//                System.out.print(this.counter);
//            }
//}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Samurai sa = new Samurai();
        Samurai sa2 = new Samurai();
        sa.howMany();
        sa.attack(sa2);
        
        
    }
    
}
