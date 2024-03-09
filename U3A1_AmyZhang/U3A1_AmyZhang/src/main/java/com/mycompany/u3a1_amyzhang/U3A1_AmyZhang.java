/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.u3a1_amyzhang;
import java.util.*;

/**
 * A console program that uses recursion to find the term of a modified Fibonacci sequence
 * @author Amy Zhang
 */
public class U3A1_AmyZhang {

    public static void main(String[] args) {
        // try-catch with resources, will always close Scanner afterwards
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the term number which you would like to know (or an invalid response to exit): ");
            int num = input.nextInt();
            
            while (true) { // continues asking until exception is raised
                if (num <= 0) throw new InputMismatchException(); // errors if negative
                System.out.println("Term #" + num + " is " + modifiedFibonacci(num - 1));
                System.out.print("Enter the term number which you would like to know (or an invalid response to exit): ");
                num = input.nextInt();
            }
        
        } catch (InputMismatchException e) {
            System.out.println("That is not a positive integer, goodbye!");
        }
    }
    
    /**
     * Calculates the term of a modified Fibonacci sequence using recursion
     * @param num The term of the sequence starting from 0
     * @return The value of the term in the sequence
     */
    public static int modifiedFibonacci(int num) {
        // base cases, to break the recursion loop
        if (num == 0) return 3;
        if (num == 1) return 5;
        if (num == 2) return 8;
        // calls its own method with a different parameter
        return modifiedFibonacci(num - 1) + modifiedFibonacci(num - 2)  + modifiedFibonacci(num - 3);
    }
}
