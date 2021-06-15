/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneassignment;

/**
 *
 * @author black
 */
public class PhoneAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Galaxy s9 = new Galaxy("s9",99,"verizon","ring ring rins");
        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());
        IPhone iphoneten = new IPhone("x",100,"AT&T","Zing");
        iphoneten.displayInfo();
        System.out.println(iphoneten.ring());
        System.out.println(iphoneten.unlock());
    }
    
}
