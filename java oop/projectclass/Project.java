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
public class Project {
        public
        String name;
        String description;
       void elevatorPitch(){
           System.out.print(name + ":" + description);
       }
        public Project()
        {}
        
        public Project(String name) {
        this.name=name;
                System.out.println(name);
        }

        public Project(String name, String description) {
            this.name=name;
            this.description=description;
                System.out.println(name);
                System.out.println(description);
        }


        
}

