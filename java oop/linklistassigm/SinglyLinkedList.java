/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linklistassigm;

/**
 *
 * @author black
 */
public class SinglyLinkedList{
        public Node head;
        int value;
    public SinglyLinkedList() {
        
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove(){
        Node runner =head.next;
        Node remover=head;
        while(runner.next !=null){
          runner = runner.next;
          remover = remover.next;
        }
        remover.next=null;
}       
    public void printValues(){
        Node runner = head;
        while(runner.next != null){
            System.out.println(runner.value);
            runner=runner.next;
        }
    }
}
