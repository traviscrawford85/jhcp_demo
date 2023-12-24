package com.cclab.demo.controller;

import com.cclab.demo.model.Provider;
import com.cclab.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/api/providers")
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/api/providers/practice")
    public List<Provider> getProvidersByPractice(@RequestParam Long practiceId) {
        return providerService.getProvidersByPractice(practiceId);
    }

    @GetMapping("/api/providers/department")
    public List<Provider> getProvidersByDepartment(@RequestParam Long departmentId) {
        return providerService.getProvidersByDepartment(departmentId);
    }

    @GetMapping("/api/providers/acceptingPatients")
    public List<Provider> getProvidersByAcceptingNewPatients(@RequestParam Boolean isAcceptingNewPatients) {
        return providerService.getProvidersByIsAcceptingNewPatients(isAcceptingNewPatients);
    }

}