
package fizzbuzz;


public class FizzBuzz {

    public static String fizzBuzz(Integer number) {
       if( number %5 ==0 && number%3 ==0){
           return "FizzBUZZ";
       }
       if(number%3 ==0){
           return "Fizz";
       }
       if( number %5 ==0){
           return "BUZZ";
       }
       return number.toString();
    }


    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz(2));
    }
    
}
