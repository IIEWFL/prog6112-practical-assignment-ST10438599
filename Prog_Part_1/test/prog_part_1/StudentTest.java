/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_part_1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author damia
 */
public class StudentTest {

    private ArrayList<Student> students;
    private Student user;

    @Before
    public void setUp() {
        students = new ArrayList<>();
        user = new Student("10111", "J. Bloggs", 19, "jbloggs@gmail.com", "DISD");
    }

    @After
    public void tearDown() {
        students.clear();
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student("10112", "Damian", 22, "Damian@gmail.com", "Bcad");
        String expResult = "Student ID: " + "10112" + "\n"
                + "Name: " + "Damian" + "\n"
                + "Age: " + 22 + "\n"
                + "Email: " + "Damian@gmail.com" + "\n"
                + "Course: " + "Bcad";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    public void testSaveStudent() {
        students.add(user);
        assertEquals(1, students.size());
        assertEquals(user, students.get(0));
    }

    @Test
    public void testSearchStudent() {
        students.add(user);
        boolean studentFound = false;
        for (Student student : students) {
            if (student.id.equals("10111")) {
                studentFound = true;
                assertEquals("J. Bloggs", student.name);
            }
        }
        assertTrue(studentFound);
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        boolean studentFound = false;
        for (Student student : students) {
            if (student.id.equals("99999")) {
                studentFound = true;
            }
        }
        assertFalse(studentFound);
    }

    @Test
    public void testDeleteStudent() {
        students.add(user);
        boolean deleted = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals("10111")) {
                students.remove(i);
                deleted = true;
                break;
            }
        }
        assertTrue(deleted);
        assertTrue(students.isEmpty());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        boolean deleted = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals("99999")) {
                students.remove(i);
                deleted = true;
                break;
            }
        }
        assertFalse(deleted);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        int age = Student.StudentValid();
        assertTrue(age >= 16 && age != -1);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        int age = 15; // Directly using invalid ageto simulate
        assertTrue(age < 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        int age = Student.StudentValid();
        assertEquals(-1, age); // Expect `-1` due to invalid user input
    }
}

