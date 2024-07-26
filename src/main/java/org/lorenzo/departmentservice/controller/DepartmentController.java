package org.lorenzo.departmentservice.controller;

import org.lorenzo.departmentservice.model.Department;
import org.lorenzo.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    /**
     * Recupera tutti i dipartimenti.
     * @return ResponseEntity contenente la lista di tutti i Dipartimenti
     */
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    /**
     * Recupera un dipartimento tramite il suo ID.
     * @param id L'UUID del dipartimento
     * @return ResponseEntity contenente il Dipartimento, o 404 se non trovato
     */
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable UUID id) {
        return departmentService.getDepartment(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuovo dipartimento.
     * @param department L'oggetto Dipartimento da creare
     * @return ResponseEntity contenente il Dipartimento creato
     */
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.ok(createdDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable UUID id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department.getName());
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Verifica se un dipartimento esiste tramite il suo ID.
     * @param id L'UUID del dipartimento
     * @return ResponseEntity contenente true se il dipartimento esiste, false altrimenti
     */
    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsDepartmentById(@PathVariable UUID id) {
        boolean exists = departmentService.existDepartmentById(id);
        return ResponseEntity.ok(exists);
    }


}
