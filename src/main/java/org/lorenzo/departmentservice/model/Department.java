package org.lorenzo.departmentservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;


@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Transient
    private List<Employee> employees;

    public Department() {
        // Default constructor
    }

    public Department(UUID id,  String name) {
        this.id = id;
        this.name = name;
    }


//    public void addEmployee(Employee employee) {
//        employees.add(employee);
//        employee.setDepartment(this);
//    }
//
//    public void removeEmployee(Employee employee) {
//        employees.remove(employee);
//        employee.setDepartment(null);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

