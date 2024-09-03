/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_part_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author damia
 */
public class Student {

    // Class fields
    String id;
    String name;
    int age;
    String email;
    String course;

    // Constructor to initialize a Student object with given details
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Overriding the toString method to display student details in a readable format
    public String toString() {
        return "Student ID: " + id + "\n"
                + "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Email: " + email + "\n"
                + "Course: " + course;
    }

    // Method to capture and save a new student's details
    public static void SaveStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCAPTURE A NEW STUDENT");
        System.out.println("********************");

        // Prompt for student ID and name
        System.out.print("Enter the student id: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();

        // Prompt for student age using the StudentValid method to ensure valid input
        int studentAge = StudentValid();

        // Prompt for student email and course
        System.out.print("Enter the student email: ");
        String studentEmail = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String studentCourse = scanner.nextLine();

        // Create a new Student object and add it to the list of students
        Student newStudent = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        students.add(newStudent);

        // Confirmation message to indicate successful save
        System.out.println("\nStudent details have been successfully saved!");
    }

    // Method to search for a student by ID and display their details
    public static void SearchStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the student ID to search: ");
        String studentId = scanner.nextLine();

        boolean studentFound = false; // Flag to track if the student is found

        // Loop through the list of students
        for (Student student : students) {
            // Check if the current student's ID matches the input ID
            if (student.id.equals(studentId)) {
                System.out.println("\nStudent found!");
                System.out.println(student.toString()); // Display the student's details
                studentFound = true;
                break; // Exit the loop once the student is found
            }
        }

        // If no student is found, display an error message
        if (!studentFound) {
            System.out.println("Error: Student with ID " + studentId + " cannot be located.");
        }
    }

    // Code attribution: The idea for this method was adapted from Stack Overflow.
    //https://stackoverflow.com/questions/28059580/remove-an-element-from-an-arraylist-and-move-that-element-into-an-array-java
    //Ravi K Thapliyal
    //https://stackoverflow.com/users/1237040/ravi-k-thapliyal
    // Method to delete a student by ID
    public static void DeleteStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the student ID to delete
        System.out.print("\nEnter the student ID to delete: ");
        String studentId = scanner.nextLine();

        // Check if the input is empty or consists of only whitespace characters
        boolean isWhitespaceOnly = true;
        for (int i = 0; i < studentId.length(); i++) {
            if (!Character.isWhitespace(studentId.charAt(i))) {
                isWhitespaceOnly = false;
                break;
            }
        }

        // If the ID is empty or whitespace only, print an error and exit
        if (studentId.isEmpty() || isWhitespaceOnly) {
            System.out.println("Error: Student ID cannot be empty or only whitespace.");
            return; // Exit the method if ID is invalid
        }

        boolean studentFound = false; // Flag to track if the student is found

        // Iterate through the list of students
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            // Check if the current student's ID matches the input ID
            if (student.id.equals(studentId)) {
                // Prompt user to confirm deletion
                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                String confirmation = scanner.nextLine();

                // Check user confirmation and delete the student if confirmed
                if (confirmation.equalsIgnoreCase("yes")) {
                    students.remove(i); // Remove the student from the list
                    System.out.println("Student with ID " + studentId + " has been successfully deleted.");
                } else {
                    System.out.println("Student deletion cancelled."); // Cancel deletion if not confirmed
                }
                studentFound = true; // Indicate that the student was found
                break; // Exit the loop as the student has been handled
            }
        }

        // Inform the user if no student with the given ID was found
        if (!studentFound) {
            System.out.println("Error: Student with ID " + studentId + " cannot be located.");
        }
    }

    // Method to generate a report of all students
    public static void StudentReport(ArrayList<Student> students) {
        System.out.println("\nSTUDENT REPORT");
        System.out.println("********************");
        if (students.isEmpty()) {
            System.out.println("No students available."); // Handle case where no students are present
        } else {
            // Loop through and display details of each student
            for (Student student : students) {
                System.out.println(student.toString());
                System.out.println("--------------------"); // Separator between students
            }
        }
    }

    // Method to exit the application
    public static void ExitStudentApplication() {
        System.out.println("Exiting the application...");
        System.exit(0); // Terminate the application
    }

    //code attribuition
    // Code attribution: The idea for this method was adapted from Stack Overflow.
    //https://stackoverflow.com/questions/679915/how-do-i-test-for-an-empty-javascript-object/32108184#32108184
    //Adam Zerner
    //https://stackoverflow.com/users/1927876/adam-zerner
    //code attribuition
    // Code attribution: The idea for this method was adapted from Stack Overflow.
    //https://stackoverflow.com/questions/20217551/check-if-a-string-matches-specific-regular-expression
    //Bohemian
    //https://stackoverflow.com/users/256196/bohemian
    public static void UpdateStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the student ID to update: ");
        String studentId = scanner.nextLine();

        boolean studentFound = false; // Flag to check if the student is found

        // Loop through the list of students to find the matching ID
        for (Student student : students) {
            if (student.id.equals(studentId)) {
                studentFound = true;

                // Display current student details
                System.out.println("\nCurrent Details:");
                System.out.println(student.toString());

                // Prompt for new details
                System.out.print("\nEnter the new name (leave blank to keep unchanged): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    student.name = newName;
                }

                // Prompt for new age and validate the input without try-catch
                System.out.print("Enter the new age (leave blank to keep unchanged): ");
                String newAge = scanner.nextLine();
                if (!newAge.isEmpty()) {
                    if (newAge.matches("\\d+")) { // Check if the input is a number
                        int age = Integer.parseInt(newAge);
                        if (age >= 16) {
                            student.age = age;
                        } else {
                            System.out.println("Invalid age! Age must be 16 or older. Keeping the old value.");
                        }
                    } else {
                        System.out.println("Invalid input! Age must be a number. Keeping the old value.");
                    }
                }

                // Prompt for new email
                System.out.print("Enter the new email (leave blank to keep unchanged): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) {
                    student.email = newEmail;
                }

                // Prompt for new course
                System.out.print("Enter the new course (leave blank to keep unchanged): ");
                String newCourse = scanner.nextLine();
                if (!newCourse.isEmpty()) {
                    student.course = newCourse;
                }

                System.out.println("\nStudent details updated successfully!");
                break; // Exit the loop once the student is updated
            }
        }

        // If the student was not found, display an error message
        if (!studentFound) {
            System.out.println("Error: Student with ID " + studentId + " cannot be located.");
        }
    }

    // Method to validate that the student's age is 16 or older
    public static int StudentValid() {
        Scanner scanner = new Scanner(System.in);
        int ageInput = 0;
        boolean valid = false;

        // Loop to repeatedly prompt for a valid age
        while (!valid) {
            System.out.print("Enter the student age: ");

            // Check if the input is a valid integer
            if (scanner.hasNextInt()) {
                ageInput = scanner.nextInt();

                // Check if the age is 16 or older
                if (ageInput >= 16) {
                    valid = true; // Exit loop if valid age is entered
                } else {
                    System.out.println("You have entered an incorrect student age! Age must be 16 or older.");
                }
            } else {
                System.out.println("You have entered an incorrect student age! Only numbers are allowed.");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
        }

        return ageInput; // Return the validated age
    }
}
