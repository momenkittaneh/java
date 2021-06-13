/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasics;

/**
 *
 * @author black
 */
public class JavaBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        theloops funplace = new theloops();
//        //first
        funplace.printnum(255);
        //second
        funplace.oddprint(255);
//        //third
        funplace.printsum(255);
//        //fourth
        int[] x ={1,3,5,7,9,13};
        funplace.arrprint(x);
//        //fifth
        System.out.print(funplace.maxarr(x));
//        //sixth
        System.out.print(funplace.avgarr(x));
//        //seventh
        int[] odd = funplace.oddarr(255);
        funplace.arrprint(odd);
//        //eigth
        int[] negarr = {1,3,5,7};
        funplace.greaterthany(negarr, 3);
//        //ninth
        int[] firstarr = {1, 5, 10, -2};
        int[] sqrarr= funplace.arrsquare(firstarr);
        funplace.arrprint(sqrarr);
//        //tenth
        int[] fullof= {1, 5, 10, -2};
        int[] notfull= funplace.absarr(fullof);
        funplace.arrprint(notfull);
//      
        int[] notgood ={1, 5, 10, 7, -2};
        int[] good = funplace.maxminavg(notgood);
        funplace.arrprint(good);
    }
    
}
