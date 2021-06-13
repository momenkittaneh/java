/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzling;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class puzzles {
// Create an array with the following values: 3,5,1,2,7,9,8,13,25,32.Print the sum of all numbers in the array.
//Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above,
//it should return an array with the values of 13,25,32)
int[] arrsum (int[] a){
        int[] newarr =new int[a.length];
        int sum=0;
        int z=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(a[i]>10){
                newarr[z]=a[i];
                z++;
    }} 
        return newarr;
}
// Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa.
//Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
String[] nameshuffle(String[] a){
    String[] newarr = new String[a.length];
    int z =0;
    List<String> strList = Arrays.asList(a);  //from google :)
    Collections.shuffle(strList);
    System.out.println(strList);
    for (String a1 : a) {
        if (a1.length() > 5) {
            newarr[z] = a1;
            z++;
}}
    return newarr;
}

// Create an array that contains all 26 letters of the alphabet (this array must have 26 values).
//Shuffle the array and, after shuffling, display the last letter from the array.
//Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.
void charsuff(){
String [] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    List<String> shufflei = Arrays.asList(alpha);
    Collections.shuffle(shufflei);
    System.out.println("the first alphabet is : " + alpha[0]);
        if (alpha[0] == "a" || alpha[0] == "e" || alpha[0] == "i" || alpha[0] == "o" || alpha[0] == "u"){
        System.out.println("this is a vowel!");   
    }
        System.out.println("the last alphabet is : " + alpha[alpha.length-1]);
}
//To shuffle a collection, you can use the shuffle method of the Collections class. Collections Class documentation
// Generate and return an array with 10 random numbers between 55-100.
Integer[] randomarray(){
    Integer[] newarr = new Integer[10];

    Random r = new Random();
    for(int i=0;i<newarr.length;i++){
        newarr[i] = r.nextInt(100-55)+55;
        
    }
    return newarr;
}


//To get a random integer, you can use the nextInt method of the Random class. Random Class documentation
// Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
Integer[] randomsortedarray(){
    Integer[] newarr = new Integer[10];

    Random r = new Random();
    for(int i=0;i<newarr.length;i++){
        newarr[i] = r.nextInt(100-55)+55;
        
    }
    Arrays.sort(newarr);
    return newarr;
}

//To sort a collection, you can use the sort method of the Collections class.

// Create a random string that is 5 characters long.
public void alpharandom(){
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int length = 5;
    for(int i = 0; i < length; i++) {
      int index = random.nextInt(alphabet.length());
      char randomChar = alphabet.charAt(index);
      sb.append(randomChar);}
    String randomString = sb.toString();
    System.out.println("Random String is: " + randomString);
}
// Generate an array with 10 random strings that are each 5 characters long
public String[] newalpha(){
    String[] newarr= new String[10];
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int length = 5;
    for(int j=0;j<newarr.length;j++){
        sb.delete(0, 5);
    for(int i = 0; i < length; i++) {
      int index = random.nextInt(alphabet.length());
      char randomChar = alphabet.charAt(index);
      sb.append(randomChar);}
    String randomString = sb.toString();
    newarr[j]= randomString;}

return newarr;
}}

////////////////////////main
public class Puzzling {
    public static void main(String[] args) {
        puzzles a = new puzzles();
        String[] arr= {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
       String[] neware = a.nameshuffle(arr);
        for(int i=0;i<neware.length;i++){
            System.out.println(neware[i]);}
        a.charsuff();
        a.alpharandom();
        String[] newarr = a.newalpha();
        for(int j=0;j<newarr.length;j++){
        System.out.println(newarr[j]);}
}}