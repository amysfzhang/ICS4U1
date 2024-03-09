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
public class Rectangle extends Shape{

    /**
     * Constructor for rectangle shape
     * @param length
     * @param width 
     */
    public Rectangle(double length, double width) {
        this.dimensionsList[0] = length;
        this.dimensionsList[1] = width;
    }
    
    @Override
    public double getArea() {
        return dimensionsList[0] * dimensionsList[1];
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Rectangle: {Length: " + this.dimensionsList[0] + ", Width: " + this.dimensionsList[1] + "} ";
    }
    
    //getter methods
    public double getLength() {
        return dimensionsList[0];
    }
    
    public double getWidth() {
        return dimensionsList[1];
    }
    
    //setter methods
    public void setLength(double length) {
        dimensionsList[0] = length;
    }
    
    public void getWidth(double width) {
        dimensionsList[1] = width;
    }
}
