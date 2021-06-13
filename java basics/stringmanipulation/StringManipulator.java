/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanipulation;

/**
 *
 * @author black
 */
class StringManipulator {
    
    String trimAndConcat(String str1,String str2){

        String newstring=str1.trim().concat(str2.trim());
        return newstring;
    }
    Integer getIndexOrNull(String str1,char letter){
       int a= str1.indexOf(letter);
       return a;
        
    }
        Integer getIndexOrNull(String str1,String str2){
       int a= str1.indexOf(str2);
       return a;
        
    }
        String concatSubstring(String str1,Integer firstsub,Integer secendsub,String str2){
            String subfirst = str1.substring(firstsub, secendsub);
            String aftersub = subfirst.concat(str2);
            return aftersub;
        }
}
