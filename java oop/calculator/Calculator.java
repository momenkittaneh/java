/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author black
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       		cal ope = new cal();
		ope.setOperandOne(10.5);
		ope.setOperation("+");
		ope.setOperandTwo(5.2);
		ope.performOperation();
		ope.getResults();

    }
    
}
