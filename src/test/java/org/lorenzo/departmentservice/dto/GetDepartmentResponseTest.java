package org.lorenzo.departmentservice.dto;


import org.lorenzo.departmentservice.model.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class GetDepartmentResponseTest {

    @Test
    void testConstructorAndGetter() {
        Department mockDepartment = Mockito.mock(Department.class);
        GetDepartmentResponse response = new GetDepartmentResponse().department(mockDepartment);
        assertEquals(mockDepartment, response.getDepartment());
    }

    @Test
    void testSetter() {
        GetDepartmentResponse response = new GetDepartmentResponse();
        Department mockDepartment = Mockito.mock(Department.class);
        response.setDepartment(mockDepartment);
        assertEquals(mockDepartment, response.getDepartment());
    }

    @Test
    void testEquals() {
        Department mockDepartment1 = Mockito.mock(Department.class);
        Department mockDepartment2 = Mockito.mock(Department.class);

        GetDepartmentResponse response1 = new GetDepartmentResponse().department(mockDepartment1);
        GetDepartmentResponse response2 = new GetDepartmentResponse().department(mockDepartment1);
        GetDepartmentResponse response3 = new GetDepartmentResponse().department(mockDepartment2);

        assertTrue(response1.equals(response2));
        assertFalse(response1.equals(response3));
        assertFalse(response1.equals(null));
        assertFalse(response1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        Department mockDepartment = Mockito.mock(Department.class);
        GetDepartmentResponse response1 = new GetDepartmentResponse().department(mockDepartment);
        GetDepartmentResponse response2 = new GetDepartmentResponse().department(mockDepartment);

        assertEquals(response1.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        Department mockDepartment = Mockito.mock(Department.class);
        Mockito.when(mockDepartment.toString()).thenReturn("MockDepartment");

        GetDepartmentResponse response = new GetDepartmentResponse().department(mockDepartment);
        String expectedString = "class GetDepartmentResponse {\n    department: MockDepartment\n}";
        assertEquals(expectedString, response.toString());
    }

    @Test
    void testNullDepartment() {
        GetDepartmentResponse response = new GetDepartmentResponse();
        assertNull(response.getDepartment());
    }

    @Test
    void testToIndentedString() {
        GetDepartmentResponse response = new GetDepartmentResponse();
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
        GetDepartmentResponse response = new GetDepartmentResponse();
        response.setDepartment(null);
        assertNull(response.getDepartment());
    }
}