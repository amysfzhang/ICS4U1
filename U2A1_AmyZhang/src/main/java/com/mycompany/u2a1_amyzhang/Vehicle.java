/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.u2a1_amyzhang;
//import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 *
 * @author Amy Zhang
 * Date: November 3, 2023
 * Storing information about a trip by vehicle's profit
 * 
 */
public class Vehicle {
    
    //Declaring instance variables
    private String licensePlate;
    private int passengerNum;
    private double passengerFare, fuelEfficiency;
    //Declaring class variables
    private static double gasPrice, distance;
    private final int PROFIT = 400; //constant for base profit level
    
    /**
     * Constructor, creates new Vehicle
     * @param passengerNum number of passengers
     * @param passengerFare the fare of each passenger
     * @param fuelEfficiency the amount of gas per km (L/km) of the vehicle
     */
    public Vehicle (int passengerNum, double passengerFare, double fuelEfficiency) {
        this.passengerNum = passengerNum;
        this.passengerFare = passengerFare;
        this.fuelEfficiency = fuelEfficiency;
    }

    /**
     * Overloaded Constructor, creates new Vehicle
     * @param licensePlate the letters and number on the license plate of the vehicle
     * @param passengerNum number of passengers
     * @param passengerFare the fare of each passenger
     * @param fuelEfficiency the amount of gas per km (L/km) of the vehicle
     */
    public Vehicle(String licensePlate, int passengerNum, double passengerFare, double fuelEfficiency) {
        this.licensePlate = licensePlate;
        this.passengerNum = passengerNum;
        this.passengerFare = passengerFare;
        this.fuelEfficiency = fuelEfficiency;
    }
    /**
     * @return revenue generated by a vehicle
     */
    public double revenue() {
        return Math.round(passengerNum * passengerFare * 100) / 100.0;
    }
    
    /**
     * @return the total cost of the trip
     */
    public double totalCost() {
        return Math.round(distance * fuelEfficiency * gasPrice * 100) / 100.0;
    }
    
    /**
     * @return the profit of a trip by the vehicle
     */
    public double calculateProfit() {
        return this.revenue() - this.totalCost();
    }
    
    /**
     * @return whether or not the profit is higher than class variable PROFIT
     */
    public boolean isProfitable() {
        if (this.calculateProfit() > PROFIT) {
            return true;
        } else {
                return false;
        }
    }
    
    /**
     * @param a vehicle one selected by user
     * @param b vehicle two selected by user
     * @return the vehicle with the higher profit, or null if equal
     */
    public static Vehicle compareTo(Vehicle a, Vehicle b) {
        if (a.calculateProfit() > b.calculateProfit()) {
            return a;
        } else if (b.calculateProfit() > a.calculateProfit()){
            return b;
        } else {
            return null;
        }
    }

    /**
     * @return a string of the values in the vehicle
     */
    @Override
    public String toString() {
        return "Vehicle{" 
                + "licensePlate=" + licensePlate 
                + ", passengerNum=" + passengerNum 
                + ", passengerFare=" + passengerFare
                + ", fuelEfficiency=" + fuelEfficiency 
                + ", PROFIT=" + PROFIT + '}';
        //ToStringBuilder.reflectionToString(this);
    }

    //Setter methods
    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    public void setPassengerFare(double passengerFare) {
        this.passengerFare = passengerFare;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public static void setDistance(double distance) {
        Vehicle.distance = distance;
    }

    public static void setGasPrice(double gasPrice) {
        Vehicle.gasPrice = gasPrice;
    }

    //Getter methods
    public int getPassengerNum() {
        return passengerNum;
    }

    public double getPassengerFare() {
        return passengerFare;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public double getDistance() {
        return distance;
    }

    public static double getGasPrice() {
        return gasPrice;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getPROFIT() {
        return PROFIT;
    }
    
     
}