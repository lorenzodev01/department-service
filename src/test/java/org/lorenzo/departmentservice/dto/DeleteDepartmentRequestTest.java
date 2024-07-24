package org.lorenzo.departmentservice.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class DeleteDepartmentRequestTest {

    @Test
    void testConstructorAndGetter() {
        UUID id = UUID.randomUUID();
        DeleteDepartmentRequest request = new DeleteDepartmentRequest().id(id);
        assertEquals(id, request.getId());
    }

    @Test
    void testSetter() {
        DeleteDepartmentRequest request = new DeleteDepartmentRequest();
        UUID id = UUID.randomUUID();
        request.setId(id);
        assertEquals(id, request.getId());
    }

    @Test
    void testEquals() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        DeleteDepartmentRequest request1 = new DeleteDepartmentRequest().id(id1);
        DeleteDepartmentRequest request2 = new DeleteDepartmentRequest().id(id1);
        DeleteDepartmentRequest request3 = new DeleteDepartmentRequest().id(id2);

        assertTrue(request1.equals(request2));
        assertFalse(request1.equals(request3));
        assertFalse(request1.equals(null));
        assertFalse(request1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        UUID id = UUID.randomUUID();
        DeleteDepartmentRequest request1 = new DeleteDepartmentRequest().id(id);
        DeleteDepartmentRequest request2 = new DeleteDepartmentRequest().id(id);

        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        DeleteDepartmentRequest request = new DeleteDepartmentRequest().id(id);
        String expectedString = "class DeleteDepartmentRequest {\n    id: " + id + "\n}";
        assertEquals(expectedString, request.toString());
    }

    @Test
    void testNullId() {
        DeleteDepartmentRequest request = new DeleteDepartmentRequest();
        assertNull(request.getId());
    }

    @Test
    void testToIndentedString() {
        DeleteDepartmentRequest request = new DeleteDepartmentRequest();
        assertEquals("null", request.toString().split("\n")[1].trim().split(": ")[1]);

        UUID id = UUID.randomUUID();
        request.setId(id);
        assertEquals(id.toString(), request.toString().split("\n")[1].trim().split(": ")[1]);
    }
}