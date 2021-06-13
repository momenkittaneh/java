/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hashmatique;
import java.util.HashMap;
import java.util.Set;


public class Hashmatique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("courtsycall", "here comes the danger up in this club");
        userMap.put("phoenix", "What are you willing to lose? \n You cover your wounds, but underneath them ");
        userMap.put("legends never die", "When the world is calling you\n" +
                    "Can you hear them screaming out your name?");
        userMap.put("angel of the shot gun", "I'm an angel with a shotgun, shotgun, shotgun");
        Set<String> keys = userMap.keySet();
        keys.remove("angel of the shot gun");
        for(String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key));    
        }

    }
    
}
