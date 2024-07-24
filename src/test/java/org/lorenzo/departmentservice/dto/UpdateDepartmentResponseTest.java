package org.lorenzo.departmentservice.dto;


import org.lorenzo.departmentservice.model.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class UpdateDepartmentResponseTest {

    @Test
    void testConstructorAndGetter() {
        Department mockDepartment = Mockito.mock(Department.class);
        UpdateDepartmentResponse response = new UpdateDepartmentResponse().department(mockDepartment);
        assertEquals(mockDepartment, response.getDepartment());
    }

    @Test
    void testSetter() {
        UpdateDepartmentResponse response = new UpdateDepartmentResponse();
        Department mockDepartment = Mockito.mock(Department.class);
        response.setDepartment(mockDepartment);
        assertEquals(mockDepartment, response.getDepartment());
    }

    @Test
    void testEquals() {
        Department mockDepartment1 = Mockito.mock(Department.class);
        Department mockDepartment2 = Mockito.mock(Department.class);

        UpdateDepartmentResponse response1 = new UpdateDepartmentResponse().department(mockDepartment1);
        UpdateDepartmentResponse response2 = new UpdateDepartmentResponse().department(mockDepartment1);
        UpdateDepartmentResponse response3 = new UpdateDepartmentResponse().department(mockDepartment2);

        assertTrue(response1.equals(response2));
        assertFalse(response1.equals(response3));
        assertFalse(response1.equals(null));
        assertFalse(response1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        Department mockDepartment = Mockito.mock(Department.class);
        UpdateDepartmentResponse response1 = new UpdateDepartmentResponse().department(mockDepartment);
        UpdateDepartmentResponse response2 = new UpdateDepartmentResponse().department(mockDepartment);

        assertEquals(response1.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        Department mockDepartment = Mockito.mock(Department.class);
        Mockito.when(mockDepartment.toString()).thenReturn("MockDepartment");

        UpdateDepartmentResponse response = new UpdateDepartmentResponse().department(mockDepartment);
        String expectedString = "class UpdateDepartmentResponse {\n    department: MockDepartment\n}";
        assertEquals(expectedString, response.toString());
    }

    @Test
    void testNullDepartment() {
        UpdateDepartmentResponse response = new UpdateDepartmentResponse();
        assertNull(response.getDepartment());
    }

    @Test
    void testToIndentedString() {
        UpdateDepartmentResponse response = new UpdateDepartmentResponse();
        assertEquals("null", response.toString().split("\n")[1].trim().split(": ")[1]);

        Department mockDepartment = Mockito.mock(Department.class);
        Mockito.when(mockDepartment.toString()).thenReturn("MockDepartment");
        response.setDepartment(mockDepartment);
        assertEquals("MockDepartment", response.toString().split("\n")[1].trim().split(": ")[1]);
    }

    @Test
    void testNotNullAnnotation() {
        // This test doesn't actually enforce the @NotNull constraint,
        // but it's here to remind that the field should not be null in practice
        UpdateDepartmentResponse response = new UpdateDepartmentResponse();
        response.setDepartment(null);
        assertNull(response.getDepartment());
    }
}