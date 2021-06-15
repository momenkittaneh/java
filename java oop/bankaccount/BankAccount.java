/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author black
 */
public class BankAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank momen = new Bank(1000,1000);
        momen.getbalance();
        momen.getsavingbalance();
        momen.insertbalance(1000);
        momen.insertsavingbalance(1000);
        momen.withdraw(100);
        momen.total();
    }
    
}
