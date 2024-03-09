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
public class Ellipse extends Shape{
    
    /**
     * Constructor for circle shape
     * @param radius 
     */
    public Ellipse(double radius1, double radius2) {
        this.dimensionsList[0] = radius1;
        this.dimensionsList[1] = radius2;
    }
    
    @Override
    public double getArea() {
        return dimensionsList[0] * dimensionsList[1] * Math.PI;
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Ellipse: {Radius 1: " + this.dimensionsList[0] + ", Radius 2: " + this.dimensionsList[1] + " } ";
    }
    
    //getter method
    public double getRadius1() {
        return dimensionsList[0];
    }    
    public double getRadius2() {
        return dimensionsList[1];
    }    
    
    //setter method
    public void setRadius1(double radius) {
        dimensionsList[0] = radius;
    }    
    public void setRadius2(double radius) {
        dimensionsList[1] = radius;
    }    
}
