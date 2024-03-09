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
public class Parallelogram extends Shape{

    /**
     * Constructor for parallelogram shape
     * @param length
     * @param height 
     */
    public Parallelogram(double length, double height) {
        this.dimensionsList[0] = length;
        this.dimensionsList[1] = height;
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
        return "Parallelogram: {Length: " + this.dimensionsList[0] + ", Height: " + this.dimensionsList[1] + "} ";
    }

    //getter methods
    public double getLength() {
        return dimensionsList[0];
    }
    
    public double getHeight() {
        return dimensionsList[1];
    }
    
    //setter methods
    public void setLength(double length) {
        dimensionsList[0] = length;
    }
    
    public void setHeight(double height) {
        dimensionsList[1] = height;
    }
}
