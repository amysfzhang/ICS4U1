
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice;
import java.io.*;
import java.util.*;
/**
 *
 * @author amy
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int t = num.nextInt();
        String[] lines = new String[t];
        
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= t; i++) {
            String l = input.nextLine();
            int index = Integer.parseInt(l.substring(0, l.indexOf(" "))) + l.indexOf(" ");
            

            lines[i-1] = i + " " + l.substring(l.indexOf(" ") + 1, index) + l.substring(index + 1);
        }
        
        for (String line : lines) {
            System.out.println(line);
        }
    }
}