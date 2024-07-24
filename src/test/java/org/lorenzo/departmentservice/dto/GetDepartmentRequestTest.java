package org.lorenzo.departmentservice.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class GetDepartmentRequestTest {

    @Test
    void testConstructorAndGetter() {
        UUID id = UUID.randomUUID();
        GetDepartmentRequest request = new GetDepartmentRequest().id(id);
        assertEquals(id, request.getId());
    }

    @Test
    void testSetter() {
        GetDepartmentRequest request = new GetDepartmentRequest();
        UUID id = UUID.randomUUID();
        request.setId(id);
        assertEquals(id, request.getId());
    }

    @Test
    void testEquals() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        GetDepartmentRequest request1 = new GetDepartmentRequest().id(id1);
        GetDepartmentRequest request2 = new GetDepartmentRequest().id(id1);
        GetDepartmentRequest request3 = new GetDepartmentRequest().id(id2);

        assertTrue(request1.equals(request2));
        assertFalse(request1.equals(request3));
        assertFalse(request1.equals(null));
        assertFalse(request1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        UUID id = UUID.randomUUID();
        GetDepartmentRequest request1 = new GetDepartmentRequest().id(id);
        GetDepartmentRequest request2 = new GetDepartmentRequest().id(id);

        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        GetDepartmentRequest request = new GetDepartmentRequest().id(id);
        String expectedString = "class GetDepartmentRequest {\n    id: " + id + "\n}";
        assertEquals(expectedString, request.toString());
    }

    @Test
    void testNullId() {
        GetDepartmentRequest request = new GetDepartmentRequest();
        assertNull(request.getId());
    }

    @Test
    void testToIndentedString() {
        GetDepartmentRequest request = new GetDepartmentRequest();
        assertEquals("null", request.toString().split("\n")[1].trim().split(": ")[1]);

        UUID id = UUID.randomUUID();
        request.setId(id);
        assertEquals(id.toString(), request.toString().split("\n")[1].trim().split(": ")[1]);
    }

    @Test
    void testNotNullAnnotation() {
        // This test doesn't actually enforce the @NotNull constraint,
        // but it's here to remind that the field should not be null in practice
        GetDepartmentRequest request = new GetDepartmentRequest();
        request.setId(null);
        assertNull(request.getId());
    }
}