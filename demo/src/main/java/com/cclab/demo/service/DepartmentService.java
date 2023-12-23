package com.cclab.demo.service;

import com.cclab.demo.model.Department;
import com.cclab.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department save(Department department) {
        // Additional logic or exception handling can be added here if needed
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        // Consider handling or logging cases where the department does not exist
        departmentRepository.deleteById(id);
    }
}
