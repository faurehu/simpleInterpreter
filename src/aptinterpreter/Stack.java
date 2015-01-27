/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptinterpreter;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author faurehu
 */
public class Stack {
    
    private LinkedList<Integer> stack;
    private int[] pair;
    
    public Stack() {
        
        stack = new LinkedList<Integer>();
        
    }
    
    public void addLast(int i) {
        
        stack.addLast(i);
        
    }
    
    public int[] lastTwo() {
            
        pair = new int[2];
        
        try {
            pair[0] = stack.removeLast(); 
            pair[1] = stack.removeLast();   
            
        } catch (NoSuchElementException e) {
            
            System.out.println("Your stack doesn't have enough numbers.");
            System.exit(1);
            
        }
        
        return pair;
        
    }
    
    public void addStack() {
            
        pair = lastTwo();
        addLast(pair[0]+pair[1]);
            
    }
    
    public void swap() {
        
        pair = lastTwo();
        addLast(pair[0]);
        addLast(pair[1]);
        
    }
    
    public void subtractStack() {
        
        pair = lastTwo();
        addLast(pair[1]-pair[0]);
        
    }
    
    public void multiplyStack() {
        
        pair = lastTwo();
        addLast(pair[0]*pair[1]);
        
    }
    
    public void divideStack() {
        
        pair = lastTwo();
        addLast(pair[1]/pair[0]);
        
    }
    
    public void modulusStack() {
        
        pair = lastTwo();
        addLast(pair[0]%pair[1]);
        
    }
    
    public void removeLast() {
        
        stack.removeLast();
        
    }
    
    public void printLastNum() {
        
        System.out.println(stack.getLast());
        
    }
    
    public void printLastASCII() {
        
        int num = stack.getLast();
        String ASCII = Character.toString((char)num);
        
        System.out.println(ASCII);
        
    }
    
    public void duplicateTop() {
        
        addLast(stack.getLast());
        
    }
    
    public int getLast() {
        
        return stack.getLast();
        
    }
    
    public void dup() {
        
        addLast(getLast());
        
    }
    
}
