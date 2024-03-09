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
public class Circle extends Shape {
   
    /**
     * Constructor for circle shape
     * @param radius 
     */
    public Circle(double radius) {
        this.dimensionsList[0] = radius;
    }
    
    @Override
    public double getArea() {
        return dimensionsList[0] * dimensionsList[0] * Math.PI;
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Circle: {Radius: " + this.dimensionsList[0] + "} ";
    }
    
    //getter method
    public double getRadius() {
        return dimensionsList[0];
    }    
    
    //setter method
    public void setRadius(double radius) {
        dimensionsList[0] = radius;
    }    
}
