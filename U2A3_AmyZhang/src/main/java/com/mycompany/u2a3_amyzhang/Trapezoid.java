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
public class Trapezoid extends Shape{
    
    /**
     * Constructor for trapezoid shape
     * @param height
     * @param baseTop
     * @param baseBottom 
     */
    public Trapezoid(double height, double baseTop, double baseBottom) {
        this.dimensionsList[0] = height;
        this.dimensionsList[1] = baseTop;
        this.dimensionsList[2] = baseBottom;
    }
    
    @Override
    public double getArea() {
        return (dimensionsList[1] + dimensionsList[2] / 2) * dimensionsList[0];
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Trapezoid: {Height: " + this.dimensionsList[0] + ", Top Base: " + this.dimensionsList[1] + ", Bottom Base: " + this.dimensionsList[2] + "} ";
    }
    
    //getter methods    
    public double getHeight() {
        return dimensionsList[0];
    }
    
    public double getBaseTop() {
        return dimensionsList[1];
    }
    
    public double getBaseBottom() {
        return dimensionsList[2];
    }
    
    //setter methods    
    public void setHeight(double height) {
        dimensionsList[0] = height;
    }
    
    public void setBaseTop(double base) {
        dimensionsList[1] = base;
    }
    
    public void setBaseBottom(double base) {
        dimensionsList[2] = base;
    }
}
