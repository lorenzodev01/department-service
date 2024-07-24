package org.lorenzo.departmentservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lorenzo.departmentservice.model.Department;
import org.lorenzo.departmentservice.service.DepartmentService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class DepartmentControllerTest {

    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDepartment() {
        UUID id = UUID.randomUUID();
        Department department = new Department();
        department.setId(id);
        department.setName("IT Department");

        when(departmentService.getDepartment(id)).thenReturn(Optional.of(department));

        ResponseEntity<Department> response = departmentController.getDepartment(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(department, response.getBody());
    }

    @Test
    void testGetDepartmentNotFound() {
        UUID id = UUID.randomUUID();

        when(departmentService.getDepartment(id)).thenReturn(Optional.empty());

        ResponseEntity<Department> response = departmentController.getDepartment(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateDepartment() {
        Department department = new Department();
        department.setName("IT Department");

        when(departmentService.createDepartment(any(Department.class))).thenReturn(department);

        ResponseEntity<Department> response = departmentController.createDepartment(department);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(department, response.getBody());
    }


    @Test
    void testDeleteDepartment() {
        UUID id = UUID.randomUUID();

        doNothing().when(departmentService).deleteDepartment(id);

        ResponseEntity<Void> response = departmentController.deleteDepartment(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }


    @Test
    void testExistsDepartmentById() {
        UUID id = UUID.randomUUID();
        boolean exists = true;

        when(departmentService.existDepartmentById(id)).thenReturn(exists);

        ResponseEntity<Boolean> response = departmentController.existsDepartmentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(exists, response.getBody());

    }
    @Test
    void testExistsDepartmentByIdNotFound() {
        UUID id = UUID.randomUUID();

        when(departmentService.existDepartmentById(id)).thenReturn(false);

        ResponseEntity<Boolean> response = departmentController.existsDepartmentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(false, response.getBody());
    }

    @Test
    void testGetAllDepartments() {
        UUID id = UUID.randomUUID();
        Department department = new Department();
        department.setId(id);
        department.setName("IT Department");

        List<Department> departments = List.of(department);

        when(departmentService.getAllDepartments()).thenReturn(departments);

        ResponseEntity<List<Department>> response = departmentController.getAllDepartments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(departments, response.getBody());
    }



}
