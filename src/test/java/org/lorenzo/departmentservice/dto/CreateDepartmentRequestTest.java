package org.lorenzo.departmentservice.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreateDepartmentRequestTest {

    @Test
    void testConstructorAndGetter() {
        CreateDepartmentRequest request = new CreateDepartmentRequest().name("IT Department");
        assertEquals("IT Department", request.getName());
    }

    @Test
    void testSetter() {
        CreateDepartmentRequest request = new CreateDepartmentRequest();
        request.setName("HR Department");
        assertEquals("HR Department", request.getName());
    }

    @Test
    void testEquals() {
        CreateDepartmentRequest request1 = new CreateDepartmentRequest().name("Finance");
        CreateDepartmentRequest request2 = new CreateDepartmentRequest().name("Finance");
        CreateDepartmentRequest request3 = new CreateDepartmentRequest().name("Marketing");

        assertTrue(request1.equals(request2));
        assertFalse(request1.equals(request3));
        assertFalse(request1.equals(null));
        assertFalse(request1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        CreateDepartmentRequest request1 = new CreateDepartmentRequest().name("Sales");
        CreateDepartmentRequest request2 = new CreateDepartmentRequest().name("Sales");

        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        CreateDepartmentRequest request = new CreateDepartmentRequest().name("Engineering");
        String expectedString = "class CreateDepartmentRequest {\n    name: Engineering\n}";
        assertEquals(expectedString, request.toString());
    }

    @Test
    void testNullName() {
        CreateDepartmentRequest request = new CreateDepartmentRequest();
        assertNull(request.getName());
    }
}