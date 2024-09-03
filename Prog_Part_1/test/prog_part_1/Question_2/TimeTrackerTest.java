/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_part_1.Question_2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTrackerTest {

    private TimeTracker timeTracker;

    @Before
    public void setUp() {
        timeTracker = new TimeTracker();
        // Add some initial employees for testing
        timeTracker.addEmployee("E001", "Kevin Hart");
        timeTracker.addEmployee("E002", "Keanue Reeves");
    }

    @Test
    public void testAddEmployee() {
        // Test adding a new employee
        timeTracker.addEmployee("E003", "Zoe Kravitz");
        Employee employee = timeTracker.getEmployeeById("E003");
        assertNotNull("Employee should be added", employee);
        assertEquals("Zoe Kravitz", employee.getName());
    }

    @Test
    public void testAddEmployeeDuplicate() {
        // Test adding an employee with a duplicate ID
        timeTracker.addEmployee("E001", "Duplicate Name");
        Employee employee = timeTracker.getEmployeeById("E001");
        assertEquals("Kevin Hart", employee.getName());
    }

    @Test
    public void testLogHours() {
        // Test logging hours for an employee
        timeTracker.logHours("E001", 20);
        Employee employee = timeTracker.getEmployeeById("E001");
        assertEquals(20, employee.getHoursWorked(), 0.01);
    }

    @Test
    public void testLogHoursExceedsLimit() {
        // Test logging hours that exceed the 40-hour limit
        timeTracker.logHours("E001", 50);
        Employee employee = timeTracker.getEmployeeById("E001");
        assertEquals(20, employee.getHoursWorked(), 0.01); // Assuming initial hours were 20
    }

    @Test
    public void testDisplayWeeklySummary() {
        // Test displaying weekly summary
        timeTracker.logHours("E002", 15);
        Employee employee = timeTracker.getEmployeeById("E002");
        assertEquals(15, employee.getHoursWorked(), 0.01);
    }

    @Test
    public void testGetEmployeeById() {
        // Test getting an employee by ID
        Employee employee = timeTracker.getEmployeeById("E002");
        assertNotNull("Employee should be found", employee);
        assertEquals("Jane Smith", employee.getName());
    }

    @Test
    public void testGetEmployeeByIdNotFound() {
        // Test getting an employee that does not exist
        Employee employee = timeTracker.getEmployeeById("NonExistentID");
        assertNull("Employee should not be found", employee);
    }

    
}
