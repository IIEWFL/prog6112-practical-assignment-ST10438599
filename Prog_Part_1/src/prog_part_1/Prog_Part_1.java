/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog_part_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author damia
 */
public class Prog_Part_1 {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
            System.out.println("*************************");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View student report");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    Student.SaveStudent(students);
                    break;
                case 2:
                    Student.SearchStudent(students);
                    break;
                case 3:
                    Student.DeleteStudent(students);
                    break;
                case 4:
                    Student.StudentReport(students);
                    break;
                case 5 :
                    Student.UpdateStudent(students);
                    break;
                case 6:
                    Student.ExitStudentApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
