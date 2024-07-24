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

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private RestTemplate restTemplate;

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentService(restTemplate, departmentRepository);
    }

    @Test
    void getDepartmentById() {
        UUID id = UUID.randomUUID();
        Department expected = new Department(id, "Test Department");
        when(restTemplate.getForObject(anyString(), eq(Department.class))).thenReturn(expected);

        Department result = departmentService.getDepartmentById(id);

        assertEquals(expected, result);
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

        assertThrows(RuntimeException.class, () -> departmentService.createDepartment(department));
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
        when(departmentRepository.save(any(Department.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Department result = departmentService.updateDepartment(id, "New Name");

        assertEquals("New Name", result.getName());
    }

    @Test
    void updateDepartment_NotFound() {
        UUID id = UUID.randomUUID();
        when(departmentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> departmentService.updateDepartment(id, "New Name"));
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
        departmentService.deleteDepartment(id);
        verify(departmentRepository).deleteById(id);
    }




}