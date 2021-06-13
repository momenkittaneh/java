
package pythagoreantheorem;


public class PythagoreanTheorem {
    public static double calculateHypotenuse(int legA, int legB) {
        int a= (int) Math.pow(legA, 2);
        int b= (int) Math.pow(legB, 2);
        double z= a+b;
        return z;
    }



    public static void main(String[] args) {
        
        int a = 10;
        int b=13;
        System.out.println("the Hypotenuse is " + Math.sqrt(calculateHypotenuse(a,b)));
        
    }
    
}
