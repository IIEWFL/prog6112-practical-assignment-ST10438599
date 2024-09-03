/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_part_1.Question_2;

/**
 *
 * @author damia
 */
class Employee extends Person {
    private double hoursWorked;  // Track the number of hours worked by the employee

    // Constructor to initialize the employee with an ID and name, and set initial hours worked to 0
    public Employee(String id, String name) {
        super(id, name);  // Call the constructor of the base class (Person)
        this.hoursWorked = 0;
    }

    // Getter for the hours worked by the employee
    public double getHoursWorked() {
        return hoursWorked;
    }

    // Add hours to the employee's total hours worked
    public void addHours(double hours) {
        this.hoursWorked += hours;
    }

    // Check if the employee can log the given hours without exceeding the 40-hour weekly limit
    public boolean canLogHours(double hours) {
        return (this.hoursWorked + hours) <= 40;
    }
}