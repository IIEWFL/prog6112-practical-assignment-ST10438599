/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_part_1.Question_2;

import java.util.ArrayList;

/**
 *
 * @author damia
 */
// Class to manage and track employees' work hours
class TimeTracker {
    private ArrayList<Employee> employees;  // List to store all employees

    // Constructor to initialize the employee list
 public TimeTracker() {
        employees = new ArrayList<>();
    }

    // Method to add a new employee to the list
    public void addEmployee(String id, String name) {
        if (getEmployeeById(id) == null) {  // Ensure no duplicate IDs
            employees.add(new Employee(id, name));  // Add the new employee to the list
        }
    }

    // Method to add a list of employees to the tracker
    public void addEmployees(ArrayList<Employee> newEmployees) {
        for (Employee emp : newEmployees) {
            addEmployee(emp.getId(), emp.getName());
        }
    }

    // Method to find an employee by their ID
    public Employee getEmployeeById(String id) {
        // Loop through the employee list to find the matching ID
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;  // Return the employee if found
            }
        }
        return null;  // Return null if no employee with the given ID is found
    }

    // Method to log hours for a specific employee
    public void logHours(String id, double hours) {
        Employee employee = getEmployeeById(id);  // Retrieve the employee by ID
        if (employee != null && employee.canLogHours(hours)) {  // Check if the employee exists and hours are within limit
            employee.addHours(hours);  // Log the hours
            System.out.println("Logged " + hours + " hours for employee " + employee.getName() + " (" + id + ").");
        } else {
            System.out.println("Cannot log hours. Employee not found or would exceed the weekly limit.");
        }
    }

    // Method to display the weekly summary of hours worked for a specific employee
    public void displayWeeklySummary(String id) {
        Employee employee = getEmployeeById(id);  // Retrieve the employee by ID
        if (employee != null) {  // Check if the employee exists
            System.out.println("Employee " + employee.getName() + " (" + id + ") has worked " + employee.getHoursWorked() + " hours this week.");
        } else {
            System.out.println("Employee not found.");
        }
    }
    
}



