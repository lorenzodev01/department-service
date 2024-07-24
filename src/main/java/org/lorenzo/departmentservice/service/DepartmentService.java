package org.lorenzo.departmentservice.service;

import org.lorenzo.departmentservice.model.Department;
import org.lorenzo.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final RestTemplate restTemplate;
    private static final String MICROSERVICE_DEPARTMENT_URL = "http://localhost:8080/api/departments"; // URL del servizio dei dipartimenti


    @Autowired
    public DepartmentService(RestTemplate restTemplate, DepartmentRepository departmentRepository) {
        this.restTemplate = restTemplate;
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartmentById(UUID id) {
        String url = MICROSERVICE_DEPARTMENT_URL + "/" + id;
        return restTemplate.getForObject(url, Department.class);
    }


    public Department createDepartment(Department department) {
        if (departmentRepository.findByName(department.getName()).isPresent()) {
            throw new RuntimeException("Department name must be unique");
        }
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartment(UUID id) {
        return departmentRepository.findById(id);
    }

    public Department updateDepartment(UUID id, String name) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(name);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    public boolean existDepartmentById(UUID id) {
        return Boolean.TRUE.equals(restTemplate.getForObject(MICROSERVICE_DEPARTMENT_URL + "/" + id, boolean.class));
    }


}
