/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;
import java.util.Random;
public class Bank {
private
    String account_number;
    double balance;
    double savingbalance;
    static int accountnum=0;
    String randomnum(){
        String alphabet = "0123456789";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int length = 10;
    for(int i = 0; i < length; i++) {
      int index = random.nextInt(alphabet.length());
      char randomChar = alphabet.charAt(index);
      sb.append(randomChar);}
    String acc = sb.toString();
        return acc;
    }
    static int totalammount=0;
    static int savingtotalammount=0;

public
    Bank() 
        {
            this.account_number=randomnum();
        }
    Bank(int balance) 
        {
            this.account_number=randomnum();
            this.balance=balance;
            totalammount+=balance;
        }
    Bank(int balance , int savingbalance) 
        {
            this.account_number=randomnum();
            this.balance=balance;
            this.totalammount+=balance;
            this.savingbalance=savingbalance;
            this.savingtotalammount+=savingbalance;
        }
    void getbalance(){
        System.out.println(this.balance);
    }
    void getsavingbalance(){
        System.out.println(this.savingbalance);
    }
    void insertbalance(int amount){
        this.balance+= amount;
        this.totalammount+=amount;
    }
    void insertsavingbalance(int amount){
        this.savingbalance+=amount;
        this.savingtotalammount+=amount;
    }
    void withdraw(int amount){
        if (this.balance> amount){
            this.balance-=amount;
        }
        else
        {
            System.out.println("insufficient funds");
        }}
    void total(){
        System.out.println(this.totalammount);
        System.out.println(this.savingtotalammount);
    }
    
}
