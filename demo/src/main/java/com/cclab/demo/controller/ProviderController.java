package com.cclab.demo.controller;

import com.cclab.demo.model.Provider;
import com.cclab.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @PostMapping
    public Provider addProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @GetMapping
    public List<Provider> getProviders(@RequestParam(required = false) Long practiceId,
                                       @RequestParam(required = false) Long departmentId,
                                       @RequestParam(required = false) Boolean isAcceptingNewPatients) {
        if (practiceId != null) {
            return providerService.getProvidersByPractice(practiceId);
        } else if (departmentId != null) {
            return providerService.getProvidersByDepartment(departmentId);
        } else if (isAcceptingNewPatients != null) {
            return providerService.getProvidersByIsAcceptingNewPatients(isAcceptingNewPatients);
        } else {
            return providerService.getAllProviders();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        Provider provider = providerService.findById(id);
        return provider != null ? ResponseEntity.ok(provider) : ResponseEntity.notFound().build();
    }


}