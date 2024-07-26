package org.lorenzo.departmentservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


public class Employee {

    @Getter
    @Setter
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;


    // Default constructor
    public Employee() {
    }

    public Employee(UUID id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
