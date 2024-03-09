/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.u2a3_amyzhang;

/**
 * 
 * @author Amy Zhang
 * Date: November 28, 2023
 * 
 */
public class Square extends Shape{
    
    /**
     * Constructor for square shape
     * @param side 
     */
    public Square(double side) {
        this.dimensionsList[0] = side;
    }
    
    @Override
    public double getArea() {
        return dimensionsList[0] * dimensionsList[0];
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Square: {side: " + this.dimensionsList[0] + "} ";
    }
        
    //getter methods    
    public double getSide() {
        return dimensionsList[0];
    }    
    
    //setter method   
     public void setSide(double side) {
        dimensionsList[0] = side;
    }    
}
