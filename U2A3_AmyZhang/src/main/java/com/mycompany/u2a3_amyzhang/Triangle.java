/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.u2a3_amyzhang;

/**
 *
 * @author 342905163
 */
public class Triangle extends Shape{
    
    /**
     * Constructor for triangle shape
     * @param height
     * @param base 
     */
    public Triangle(double height, double base) {
        this.dimensionsList[0] = height;
        this.dimensionsList[1] = base;
    }
    
    @Override
    public double getArea() {
        return dimensionsList[0] * dimensionsList[1] / 2;
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Triangle: {Height: " + this.dimensionsList[0] + ", Base: " + this.dimensionsList[1] + "} ";
    }
    
    //getter methods    
    public double getHeight() {
        return dimensionsList[0];
    }
    
    public double getBase() {
        return dimensionsList[1];
    }
    
    //setter methods    
    public void setHeight(double height) {
        dimensionsList[0] = height;
    }
    
    public void setBase(double base) {
        dimensionsList[1] = base;
    }
}
