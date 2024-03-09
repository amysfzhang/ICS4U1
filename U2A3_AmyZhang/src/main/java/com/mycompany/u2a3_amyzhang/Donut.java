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
public class Donut extends Shape{
    
    /**
     * Constructor for donut shape
     * @param radiusExterior
     * @param radiusInterior
     * @throws IOException if interior radius is bigger than exterior radius
     */
    public Donut(double radiusExterior, double radiusInterior) throws IOException {
        if (!(radiusExterior > radiusInterior)) {
            throw new IOException("Interior circle is bigger than exterior circle");
        }
        
        this.dimensionsList[0] = radiusExterior;
        this.dimensionsList[1] = radiusInterior;
    }
    
    @Override
    public double getArea() {
        return (dimensionsList[0] * dimensionsList[0] * Math.PI) - (dimensionsList[1] * dimensionsList[1] * Math.PI);
    }
    
    @Override
    public double[] getDimensionsList() {
        return dimensionsList;
    }
    
    @Override
    public String toString() {
        return "Donut: {Exterior radius: " + this.dimensionsList[0] + ", Interior raduis: " + this.dimensionsList[1] + "} ";
    }
    
    //getter methods
    public double getRadiusExterior() {
        return dimensionsList[0];
    }    
    
    public double getRadiusInterior() {
        return dimensionsList[1];
    }    
    
    //setter methods
    public void setRadiusExterior(double radius) {
        dimensionsList[0] = radius;
    }
    
    public void setRadiusInterior(double radius) {
        dimensionsList[1] = radius;
    }
}
