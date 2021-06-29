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
public class Human {
    private
           int strength= 3;
           int stealth=3;
           int intelligence =3;
           int health = 100;
    public
           void attack(Human h1){
               this.health-= h1.strength;
               System.out.print(health);
           }
}
