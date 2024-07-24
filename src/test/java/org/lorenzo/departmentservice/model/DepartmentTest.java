package org.lorenzo.departmentservice.model;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testDepartmentCreation() {
        UUID id = UUID.randomUUID();
        String name = "IT Department";
        Department department = new Department();
        department.setId(id);
        department.setName(name);

        assertEquals(id, department.getId());
        assertEquals(name, department.getName());
    }


    @Test
    void testDepartmentEquals() {
        UUID id = UUID.randomUUID();
        String name = "IT Department";

        Department department1 = new Department();
        department1.setId(id);
        department1.setName(name);

        Department department2 = new Department();
        department2.setId(id);
        department2.setName(name);

        assertEquals(department1, department2);
    }

    @Test
    void testDepartmentNotEquals() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        String name1 = "IT Department";
        String name2 = "HR Department";

        Department department1 = new Department();
        department1.setId(id1);
        department1.setName(name1);

        Department department2 = new Department();
        department2.setId(id2);
        department2.setName(name2);

        assertNotEquals(department1, department2);
    }


}
