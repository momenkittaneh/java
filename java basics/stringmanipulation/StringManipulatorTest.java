/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanipulation;

/**
 *
 * @author black
 */
public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println("the new word is: " + str); // HelloWorld 
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println("the index of letter 'o' is: " + a); // 1
        System.out.println("the index of letter 'o' is: " + b); // 4
        System.out.println("the index of letter 'o' is: " + c); // null
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer d = manipulator.getIndexOrNull(word, subString);
        Integer e = manipulator.getIndexOrNull(word, notSubString);
        System.out.println("the index of word 'llo' is " + d); // 2
        System.out.println("the index of word 'world' is " + e); // null
        String newsub = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println("the new subword is: "+ newsub); // eworld



    }
}
