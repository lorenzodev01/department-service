package org.lorenzo.departmentservice.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteDepartmentResponseTest {

    @Test
    void testConstructorAndGetter() {
        DeleteDepartmentResponse response = new DeleteDepartmentResponse().success(true);
        assertTrue(response.isSuccess());
    }

    @Test
    void testSetter() {
        DeleteDepartmentResponse response = new DeleteDepartmentResponse();
        response.setSuccess(false);
        assertFalse(response.isSuccess());
    }

    @Test
    void testEquals() {
        DeleteDepartmentResponse response1 = new DeleteDepartmentResponse().success(true);
        DeleteDepartmentResponse response2 = new DeleteDepartmentResponse().success(true);
        DeleteDepartmentResponse response3 = new DeleteDepartmentResponse().success(false);

        assertTrue(response1.equals(response2));
        assertFalse(response1.equals(response3));
        assertFalse(response1.equals(null));
        assertFalse(response1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        DeleteDepartmentResponse response1 = new DeleteDepartmentResponse().success(true);
        DeleteDepartmentResponse response2 = new DeleteDepartmentResponse().success(true);

        assertEquals(response1.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        DeleteDepartmentResponse response = new DeleteDepartmentResponse().success(true);
        String expectedString = "class DeleteDepartmentResponse {\n    success: true\n}";
        assertEquals(expectedString, response.toString());
    }

    @Test
    void testNullSuccess() {
        DeleteDepartmentResponse response = new DeleteDepartmentResponse();
        assertNull(response.isSuccess());
    }

    @Test
    void testToIndentedString() {
        DeleteDepartmentResponse response = new DeleteDepartmentResponse();
        assertEquals("null", response.toString().split("\n")[1].trim().split(": ")[1]);

        response.setSuccess(true);
        assertEquals("true", response.toString().split("\n")[1].trim().split(": ")[1]);
    }

    @Test
    void testNotNullAnnotation() {
        // This test doesn't actually enforce the @NotNull constraint,
        // but it's here to remind that the field should not be null in practice
        DeleteDepartmentResponse response = new DeleteDepartmentResponse();
        response.setSuccess(null);
        assertNull(response.isSuccess());
    }
}