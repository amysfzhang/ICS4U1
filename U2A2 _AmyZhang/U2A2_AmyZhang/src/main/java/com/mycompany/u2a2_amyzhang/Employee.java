/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.u2a2_amyzhang;
import java.util.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author 342905163
 */
public class Employee {
    
    //Declaring instance variables
    private String firstName, lastName;
    private int employeeIdNumber;
    private double annualSalary;
    private Date startDate;

    /**
     * Constructor for an employee
     * @param firstName
     * @param lastName
     * @param IDNum
     * @param annualSalary
     * @param startDate 
     */
    public Employee(String firstName, String lastName, int employeeIdNumber, double annualSalary, Date startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeIdNumber = employeeIdNumber;
        this.annualSalary = annualSalary;
        this.startDate = startDate;
    }

    //getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeIdNumber() {
        return employeeIdNumber;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        //rounds salary
        annualSalary = Math.round(annualSalary * 100) /100.0;
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", IDNum=" + employeeIdNumber + ", annualSalary=" + annualSalary + ", startDate=" + startDate + '}';
    }
    
}
