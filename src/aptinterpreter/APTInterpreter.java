/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptinterpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faurehu
 */
public class APTInterpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            Scanner sc = new Scanner(new File("p3.myl"));
            Stack stack = new Stack();
            
            ArrayList<ArrayList> al = new ArrayList<ArrayList>();
            
            while(sc.hasNextLine()) {
                
                ArrayList<String> pair = new ArrayList<String>();
                String[] arguments = sc.nextLine().split(" ");
                
                for(int i = 0; i < arguments.length; i++) {
                    
                    pair.add(arguments[i]);
                    
                }
                
                al.add(pair);
                
            };
            
            System.out.println("The program is: " + al);
            
            int pc = 0;
            
            while(pc < al.size()) {
                
                ArrayList<String> instruction = al.get(pc);
                
                if(instruction.get(0).equals("INT")) {
                    
                    System.out.println("Adding " + instruction.get(1) + " to the stack.");
                    stack.addLast(Integer.parseInt(instruction.get(1)));
                    pc++;
                    
                } else if(instruction.get(0).equals("ADD")) {
                    
                    System.out.println("Adding two last numbers in the stack.");
                    stack.addStack();
                    pc++;
                    
                } else if(instruction.get(0).equals("PRINT")) {
                    
                    System.out.println("Printing the last number of the stack.");
                    stack.printLastNum();
                    pc++;
                    
                } else if (instruction.get(0).equals("JGE")) {
                    
                    int dir = Integer.parseInt(instruction.get(1));
                    
                    if(stack.getLast() > 0) {
                        
                        System.out.println("Jumping to the following step: " + dir);
                        pc = dir;
                        
                    } else if (stack.getLast() <= 0) {
                        
                        System.out.println("Last number in the stack is 0.");
                        pc++;
                        
                    }
                    
                } else if (instruction.get(0).equals("SUB")) {
                    
                    System.out.println("Substracting the last two numbers from the stack.");
                    stack.subtractStack();
                    pc++;
                    
                } else if (instruction.get(0).equals("SWAP")) {
                    
                    System.out.println("Swapping the last two numbers in the stack.");
                    stack.swap();
                    pc++;
                    
                } else if (instruction.get(0).equals("CALL")) {
                    
                    int newdir = pc+1;
                    System.out.println("Adding " + newdir + " to the stack.");
                    stack.addLast(newdir);                    
                    pc = Integer.parseInt(instruction.get(1));
                    
                } else if (instruction.get(0).equals("RET")) {
                    
                    System.out.println("Jumping to the last number in the stack.");
                    int newdir = stack.getLast();
                    stack.removeLast();
                    pc = newdir;
                    
                } else if (instruction.get(0).equals("EXIT")) {
                    
                    System.out.println("Exiting the program.");
                    break;
                    
                } else if (instruction.get(0).equals("DUP")) {
                    
                    System.out.println("Duplicating last two numbers in the stack");
                    stack.dup();
                    
                } else if (instruction.get(0).equals("JEQ")) {
                    
                    if(stack.getLast() == 0) {
                        
                        System.out.println("Jumping to " + instruction.get(1));
                        pc = Integer.parseInt(instruction.get(1));
                        
                    } else {
                        
                        pc++;
                        
                    }
                    
                } else if (instruction.get(0).equals("POP")) {
                    
                    System.out.println("Removing last element of the stack.");
                    stack.removeLast();
                    
                }  
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APTInterpreter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
