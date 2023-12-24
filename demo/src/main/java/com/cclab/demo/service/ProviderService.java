package com.cclab.demo.service;
import com.cclab.demo.handler.ResourceNotFoundException;
import com.cclab.demo.model.Provider;
import com.cclab.demo.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import com.cclab.demo.handler.ResourceNotFoundException;
import java.util.List;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

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


    public List<Provider> findByDepartmentId(Long id) {
        return providerRepository.findByDepartmentId(id);
    }
}

