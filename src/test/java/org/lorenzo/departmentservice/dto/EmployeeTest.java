package org.lorenzo.departmentservice.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class EmployeeTest {

    @Test
    void testSetAndGetId() {
        Employee employee = new Employee();
        UUID id = UUID.randomUUID();
        employee.setId(id);
        assertEquals(id, employee.getId());
    }

    @Test
    void testSetAndGetName() {
        Employee employee = new Employee();
        String name = "John Doe";
        employee.setName(name);
        assertEquals(name, employee.getName());
    }

    @Test
    void testSetAndGetDepartmentId() {
        Employee employee = new Employee();
        UUID departmentId = UUID.randomUUID();
        employee.setDepartmentId(departmentId);
        assertEquals(departmentId, employee.getDepartmentId());
    }

    @Test
    void testDefaultConstructor() {
        Employee employee = new Employee();
        assertNull(employee.getId());
        assertNull(employee.getName());
        assertNull(employee.getDepartmentId());
    }




}