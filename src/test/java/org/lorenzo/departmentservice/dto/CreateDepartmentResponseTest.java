package org.lorenzo.departmentservice.dto;


import org.lorenzo.departmentservice.model.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class CreateDepartmentResponseTest {

    @Test
    void testConstructorAndGetter() {
        Department mockDepartment = Mockito.mock(Department.class);
        CreateDepartmentResponse response = new CreateDepartmentResponse().department(mockDepartment);
        assertEquals(mockDepartment, response.getDepartment());
    }

    @Test
    void testSetter() {
        CreateDepartmentResponse response = new CreateDepartmentResponse();
        Department mockDepartment = Mockito.mock(Department.class);
        response.setDepartment(mockDepartment);
        assertEquals(mockDepartment, response.getDepartment());
    }

    @Test
    void testEquals() {
        Department mockDepartment1 = Mockito.mock(Department.class);
        Department mockDepartment2 = Mockito.mock(Department.class);

        CreateDepartmentResponse response1 = new CreateDepartmentResponse().department(mockDepartment1);
        CreateDepartmentResponse response2 = new CreateDepartmentResponse().department(mockDepartment1);
        CreateDepartmentResponse response3 = new CreateDepartmentResponse().department(mockDepartment2);

        assertTrue(response1.equals(response2));
        assertFalse(response1.equals(response3));
        assertFalse(response1.equals(null));
        assertFalse(response1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        Department mockDepartment = Mockito.mock(Department.class);
        CreateDepartmentResponse response1 = new CreateDepartmentResponse().department(mockDepartment);
        CreateDepartmentResponse response2 = new CreateDepartmentResponse().department(mockDepartment);

        assertEquals(response1.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        Department mockDepartment = Mockito.mock(Department.class);
        Mockito.when(mockDepartment.toString()).thenReturn("MockDepartment");

        CreateDepartmentResponse response = new CreateDepartmentResponse().department(mockDepartment);
        String expectedString = "class CreateDepartmentResponse {\n    department: MockDepartment\n}";
        assertEquals(expectedString, response.toString());
    }

    @Test
    void testNullDepartment() {
        CreateDepartmentResponse response = new CreateDepartmentResponse();
        assertNull(response.getDepartment());
    }
}