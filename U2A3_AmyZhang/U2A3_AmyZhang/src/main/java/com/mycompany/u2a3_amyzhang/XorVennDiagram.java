/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.u2a3_amyzhang;

import java.io.*;

/**
 * 
 * @author Amy Zhang
 * Date: November 28, 2023
 * 
 */
public class XorVennDiagram extends Shape{
    
    /**
     * Constructor for xor Venn diagram shape with positive area
     * @param centerDistance distance between the centers of the two circles
     * @param radius1
     * @param radius2
     * @throws IOException if distance is bigger than sum of radii or distance is smaller than difference of radii
     */
    public XorVennDiagram(double centerDistance, double radius1, double radius2) throws IOException{
        if (!(centerDistance > Math.abs(radius1 - radius2))) {
            throw new IOException("Circles do not overlap, one envloppes the other");
        }
        if (!(radius1 + radius2 > centerDistance)) {
            throw new IOException("Circles do not overlap, too distant");            
        }
        
        this.dimensionsList[0] = centerDistance;
        this.dimensionsList[1] = radius1;
        this.dimensionsList[2] = radius2;
    }
    
    @Override
    public double getArea() {
        //formula from: https://www.omnicalculator.com/math/crescent-area#area-of-crescent-formula
        double lune1 = (0.5 * Math.sqrt((dimensionsList[1] + dimensionsList[2] + dimensionsList[0]) * (dimensionsList[1] + dimensionsList[2] - dimensionsList[0]) * (dimensionsList[0] + dimensionsList[1] - dimensionsList[2]) * (dimensionsList[0] + dimensionsList[2] - dimensionsList[1]))) 
                + (Math.pow(dimensionsList[1], 2) * Math.acos((Math.pow(dimensionsList[2], 2) - Math.pow(dimensionsList[1], 2) - Math.pow(dimensionsList[0], 2))/(2 * dimensionsList[1] * dimensionsList[0])))
                - (Math.pow(dimensionsList[2], 2) * Math.acos((Math.pow(dimensionsList[2], 2) - Math.pow(dimensionsList[1], 2) + Math.pow(dimensionsList[0], 2))/(2 * dimensionsList[2] * dimensionsList[0])));
        double lune2 = (Math.PI * Math.pow(dimensionsList[2], 2)) - (Math.PI * Math.pow(dimensionsList[1], 2) - lune1);
        
        return lune1 + lune2;
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "XorVennDiagram: {Center Distance: " + this.dimensionsList[0] + ", Radius 1: " + this.dimensionsList[1] + ", Radius 2: " + this.dimensionsList[2] + "} ";
    }
    
    //getter methods
    public double getCenterDistance() {
        return dimensionsList[0];
    }
    
    public double getRadius1() {
        return dimensionsList[1];
    }
    
    public double getRadius2() {
        return dimensionsList[2];
    }
    
    //setter methods
    public void setCenterDistance(double centerDistance) {
        dimensionsList[0] = centerDistance;
    }
    
    public void setRadius1(double radius1) {
        dimensionsList[1] = radius1;
    }
    
    public void setRadius2(double radius2) {
        dimensionsList[2] = radius2;
    }
    
}
