/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptinterpreter;

/**
 *
 * @author faurehu
 */
public class Pair {
    
    String[] pair = new String[2];
    
    public Pair(String[] input) {
        
        pair[0] = input[0];
        
        if(input[1] != null) {
            
            pair[1] = input[1];
            
        } else {
            
            pair[1] = " ";
            
        }
        
    }
    
}
