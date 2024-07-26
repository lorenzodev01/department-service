package org.lorenzo.departmentservice.service;

import jakarta.transaction.Transactional;
import org.lorenzo.departmentservice.exception.ResourceNotFoundException;
import org.lorenzo.departmentservice.model.Department;
import org.lorenzo.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Recupera un dipartimento tramite il suo ID.
     * @param id L'UUID del dipartimento
     * @return L'oggetto Dipartimento
     * @throws ResourceNotFoundException se il dipartimento non viene trovato
     */

    public Department getDepartmentById(UUID id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    /**
     * Crea un nuovo dipartimento.
     * @param department L'oggetto Dipartimento da creare
     * @return L'oggetto Dipartimento creato, o null se esiste già un dipartimento con lo stesso nome
     */

    @Transactional
    public Department createDepartment(Department department) {
        if (departmentRepository.findByName(department.getName()).isPresent()) {
            return null; // Return null if a department with the same name already exists
        }
        return departmentRepository.save(department);
    }

    /**
     * Recupera un dipartimento tramite il suo ID.
     * @param id L'UUID del dipartimento
     * @return Un Optional contenente l'oggetto Dipartimento se trovato
     */

    public Optional<Department> getDepartment(UUID id) {
        return departmentRepository.findById(id);
    }

    /**
     * Aggiorna un dipartimento esistente.
     * @param id L'UUID del dipartimento da aggiornare
     * @param name Il nuovo nome per il dipartimento
     * @return L'oggetto Dipartimento aggiornato, o null se il nuovo nome esiste già
     * @throws ResourceNotFoundException se il dipartimento non viene trovato
     */

    @Transactional
    public Department updateDepartment(UUID id, String name) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        if (!department.getName().equals(name) && departmentRepository.findByName(name).isPresent()) {
            return null; // Return null if the new name already exists for another department
        }

        department.setName(name);
        return departmentRepository.save(department);
    }

    /**
     * Recupera tutti i dipartimenti.
     * @return Una lista di tutti gli oggetti Dipartimento
     */
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Elimina un dipartimento tramite il suo ID.
     * @param id L'UUID del dipartimento da eliminare
     * @throws ResourceNotFoundException se il dipartimento non viene trovato
     */
    @Transactional
    public void deleteDepartment(UUID id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
    }

    /**
     * Verifica se un dipartimento esiste tramite il suo ID.
     * @param id L'UUID del dipartimento
     * @return true se il dipartimento esiste, false altrimenti
     */
    public boolean existDepartmentById(UUID id) {
        return departmentRepository.existsById(id);
    }
}