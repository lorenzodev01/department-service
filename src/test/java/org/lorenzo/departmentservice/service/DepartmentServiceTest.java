package org.lorenzo.departmentservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lorenzo.departmentservice.model.Department;
import org.lorenzo.departmentservice.repository.DepartmentRepository;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lorenzo.departmentservice.model.Department;
import org.lorenzo.departmentservice.repository.DepartmentRepository;
import org.lorenzo.departmentservice.exception.ResourceNotFoundException;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentService(departmentRepository);
    }

    @Test
    void getDepartmentById() {
        UUID id = UUID.randomUUID();
        Department expected = new Department(id, "Test Department");
        when(departmentRepository.findById(id)).thenReturn(Optional.of(expected));

        Department result = departmentService.getDepartmentById(id);

        assertEquals(expected, result);
    }

    @Test
    void getDepartmentById_NotFound() {
        UUID id = UUID.randomUUID();
        when(departmentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> departmentService.getDepartmentById(id));
    }

    @Test
    void createDepartment() {
        Department department = new Department(UUID.randomUUID(), "New Department");
        when(departmentRepository.findByName(department.getName())).thenReturn(Optional.empty());
        when(departmentRepository.save(department)).thenReturn(department);

        Department result = departmentService.createDepartment(department);

        assertEquals(department, result);
    }

    @Test
    void createDepartment_NameAlreadyExists() {
        Department department = new Department(UUID.randomUUID(), "Existing Department");
        when(departmentRepository.findByName(department.getName())).thenReturn(Optional.of(department));

        Department result = departmentService.createDepartment(department);

        assertNull(result);
    }

    @Test
    void getDepartment() {
        UUID id = UUID.randomUUID();
        Department expected = new Department(id, "Test Department");
        when(departmentRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<Department> result = departmentService.getDepartment(id);

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @Test
    void updateDepartment() {
        UUID id = UUID.randomUUID();
        Department department = new Department(id, "Old Name");
        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
        when(departmentRepository.findByName("New Name")).thenReturn(Optional.empty());
        when(departmentRepository.save(any(Department.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Department result = departmentService.updateDepartment(id, "New Name");

        assertNotNull(result);
        assertEquals("New Name", result.getName());
    }

    @Test
    void updateDepartment_NotFound() {
        UUID id = UUID.randomUUID();
        when(departmentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> departmentService.updateDepartment(id, "New Name"));
    }

    @Test
    void updateDepartment_NameAlreadyExists() {
        UUID id = UUID.randomUUID();
        Department department = new Department(id, "Old Name");
        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
        when(departmentRepository.findByName("New Name")).thenReturn(Optional.of(new Department()));

        Department result = departmentService.updateDepartment(id, "New Name");

        assertNull(result);
    }

    @Test
    void getAllDepartments() {
        List<Department> expected = Arrays.asList(
                new Department(UUID.randomUUID(), "Department 1"),
                new Department(UUID.randomUUID(), "Department 2")
        );
        when(departmentRepository.findAll()).thenReturn(expected);

        List<Department> result = departmentService.getAllDepartments();

        assertEquals(expected, result);
    }

    @Test
    void deleteDepartment() {
        UUID id = UUID.randomUUID();
        when(departmentRepository.existsById(id)).thenReturn(true);

        departmentService.deleteDepartment(id);

        verify(departmentRepository).deleteById(id);
    }

    @Test
    void deleteDepartment_NotFound() {
        UUID id = UUID.randomUUID();
        when(departmentRepository.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> departmentService.deleteDepartment(id));
    }

    @Test
    void existDepartmentById() {
        UUID id = UUID.randomUUID();
        when(departmentRepository.existsById(id)).thenReturn(true);

        boolean result = departmentService.existDepartmentById(id);

        assertTrue(result);
    }
}

