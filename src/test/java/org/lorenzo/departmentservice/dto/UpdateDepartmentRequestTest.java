package org.lorenzo.departmentservice.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class UpdateDepartmentRequestTest {

    @Test
    void testConstructorAndGetters() {
        UUID id = UUID.randomUUID();
        String name = "IT Department";
        UpdateDepartmentRequest request = new UpdateDepartmentRequest().id(id).name(name);
        assertEquals(id, request.getId());
        assertEquals(name, request.getName());
    }

    @Test
    void testSetters() {
        UpdateDepartmentRequest request = new UpdateDepartmentRequest();
        UUID id = UUID.randomUUID();
        String name = "HR Department";
        request.setId(id);
        request.setName(name);
        assertEquals(id, request.getId());
        assertEquals(name, request.getName());
    }

    @Test
    void testEquals() {
        UUID id = UUID.randomUUID();
        UpdateDepartmentRequest request1 = new UpdateDepartmentRequest().id(id).name("Finance");
        UpdateDepartmentRequest request2 = new UpdateDepartmentRequest().id(id).name("Finance");
        UpdateDepartmentRequest request3 = new UpdateDepartmentRequest().id(UUID.randomUUID()).name("Marketing");

        assertTrue(request1.equals(request2));
        assertFalse(request1.equals(request3));
        assertFalse(request1.equals(null));
        assertFalse(request1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        UUID id = UUID.randomUUID();
        UpdateDepartmentRequest request1 = new UpdateDepartmentRequest().id(id).name("Sales");
        UpdateDepartmentRequest request2 = new UpdateDepartmentRequest().id(id).name("Sales");

        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        UpdateDepartmentRequest request = new UpdateDepartmentRequest().id(id).name("Engineering");
        String expectedString = "class UpdateDepartmentRequest {\n    id: " + id + "\n    name: Engineering\n}";
        assertEquals(expectedString, request.toString());
    }

    @Test
    void testNullValues() {
        UpdateDepartmentRequest request = new UpdateDepartmentRequest();
        assertNull(request.getId());
        assertNull(request.getName());
    }

    @Test
    void testToIndentedString() {
        UpdateDepartmentRequest request = new UpdateDepartmentRequest();
        assertEquals("null", request.toString().split("\n")[1].trim().split(": ")[1]);
        assertEquals("null", request.toString().split("\n")[2].trim().split(": ")[1]);

        UUID id = UUID.randomUUID();
        request.setId(id);
        request.setName("Test Department");
        assertEquals(id.toString(), request.toString().split("\n")[1].trim().split(": ")[1]);
        assertEquals("Test Department", request.toString().split("\n")[2].trim().split(": ")[1]);
    }

    @Test
    void testNotNullAnnotation() {
        // This test doesn't actually enforce the @NotNull constraint,
        // but it's here to remind that the fields should not be null in practice
        UpdateDepartmentRequest request = new UpdateDepartmentRequest();
        request.setId(null);
        request.setName(null);
        assertNull(request.getId());
        assertNull(request.getName());
    }
}