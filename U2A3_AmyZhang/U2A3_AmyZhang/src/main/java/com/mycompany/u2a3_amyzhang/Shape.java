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
public abstract class Shape {
    //abstract variables
    protected static double unitPrice;
    protected double[] dimensionsList = new double[3];
    
    //static methods
    public static double getUnitPrice() {
        return unitPrice;
    }
    
    public static void setUnitPrice(double unitPrice) {
        Shape.unitPrice = unitPrice;
    }
    
    //same method for all shapes
    public double getCost() {
        return this.getArea() * Shape.unitPrice;
    }
    
    //abstract methods (need implementation)
    public abstract double getArea();
    public abstract double[] getDimensionsList();
    
    @Override public abstract String toString();
}
