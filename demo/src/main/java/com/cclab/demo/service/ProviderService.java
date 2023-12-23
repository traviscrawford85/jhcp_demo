package com.cclab.demo.service;

import com.cclab.demo.model.Provider;
import com.cclab.demo.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    // Error Handling
    public Provider getProviderById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider not found with id: " + id));
    }

    public List<Provider> getProvidersByPractice(Long practiceId) {
        return providerRepository.findByPracticeId(practiceId);
    }

    public List<Provider> getProvidersByDepartment(Long departmentId) {
        return providerRepository.findByDepartmentId(departmentId);
    }

    public List<Provider> getProvidersByIsAcceptingNewPatients(Boolean isAcceptingNewPatients) {
        return providerRepository.findByIsAcceptingNewPatients(isAcceptingNewPatients);
    }

    public Provider findById(Long id) {
        return providerRepository.findById(id).orElse(null); // Consider throwing an exception or
    }


    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
