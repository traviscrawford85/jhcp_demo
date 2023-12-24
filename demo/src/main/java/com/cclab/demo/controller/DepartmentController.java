package com.cclab.demo.controller;

import com.cclab.demo.model.Department;
import com.cclab.demo.model.Practice;
import com.cclab.demo.model.Provider;
import com.cclab.demo.service.DepartmentService;
import com.cclab.demo.service.PracticeService;
import com.cclab.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final ProviderService providerService;
    private final PracticeService practiceService;

    @Autowired
    public DepartmentController(DepartmentService departmentService
            , ProviderService providerService
            , PracticeService practiceService) {
        this.departmentService = departmentService;
        this.providerService = providerService;
        this.practiceService = practiceService;
    }

    // Get all departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.findAll();
        return ResponseEntity.ok(departments);
    }

    // Get a department by id
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.findById(id);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all providers by department id
    @GetMapping("/{id}/providers")
    public ResponseEntity<List<Provider>> getProvidersByDepartmentId(@PathVariable Long id) {
        List<Provider> providers = providerService.findByDepartmentId(id);
        return ResponseEntity.ok(providers);
    }

    // Get all practices by department id
    @GetMapping("/{id}/practices")
    public ResponseEntity<List<Practice>> getPracticesByDepartmentId(@PathVariable Long id) {
        List<Practice> practices = practiceService.findByDepartmentId(id);
        return ResponseEntity.ok(practices);
    }
}
