/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_part_1.Question_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author damia
 */
public class Time_Management_Tool {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeTracker tracker = new TimeTracker();  // Create an instance of TimeTracker to manage employees

        // Add initial employees
        ArrayList<Employee> initialEmployees = new ArrayList<>();
        initialEmployees.add(new Employee("E001", "John Doe"));
        initialEmployees.add(new Employee("E002", "Jane Smith"));
        tracker.addEmployees(initialEmployees);

        // Function to add multiple employees
        System.out.print("Do you want to add new employees? (yes/no): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            ArrayList<Employee> newEmployees = new ArrayList<>();
            while (true) {
                System.out.print("Enter employee ID (or type 'done' to finish): ");
                String id = scanner.next();
                if (id.equalsIgnoreCase("done")) break;

                System.out.print("Enter employee name: ");
                String name = scanner.next();
                newEmployees.add(new Employee(id, name));
            }
            tracker.addEmployees(newEmployees);
        }

        // Loop to keep the application running until the user chooses to exit
        while (true) {
            // Display options to the user
            System.out.println("\nOptions: ");
            System.out.println("1. Log hours");
            System.out.println("2. Weekly summary");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 3) {  // Exit the loop if the user chooses to exit
                break;
            }

            switch (choice) {
                case 1:
                    // Prompt the user for the employee ID and log hours
                    System.out.print("Enter employee ID: ");
                    String id = scanner.next();
                    System.out.print("Enter hours worked: ");
                    double hours = scanner.nextDouble();
                    tracker.logHours(id, hours);
                    break;
                case 2:
                    // Prompt the user for the employee ID and display the weekly summary
                    System.out.print("Enter employee ID: ");
                    id = scanner.next();
                    tracker.displayWeeklySummary(id);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        // Close the scanner to avoid resource leak
        scanner.close();
        System.out.println("Time Management App terminated.");  // Notify that the application has ended
    }
}
