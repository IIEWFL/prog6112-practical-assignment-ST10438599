/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_part_1.Question_2;

/**
 *
 * @author damia
 */
class Person {
    private String id;  // Unique identifier for the person
    private String name;  // Name of the person

    // Constructor to initialize the person's ID and name
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for the person's ID
    public String getId() {
        return id;
    }

    // Getter for the person's name
    public String getName() {
        return name;
    }
}

