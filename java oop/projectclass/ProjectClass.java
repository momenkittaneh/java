/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectclass;

/**
 *
 * @author black
 */
public class ProjectClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Project hello = new Project();
       Project hello2 = new Project("hello");
       Project hello3 = new Project("hello", "new class");
    }
    
}
