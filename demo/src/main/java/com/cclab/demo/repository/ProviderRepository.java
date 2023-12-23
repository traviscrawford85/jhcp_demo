package com.cclab.demo.repository;

import com.cclab.demo.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    // Custom query methods if needed
    List<Provider> findByIsAcceptingNewPatients(Boolean isAcceptingNewPatients);

    List<Provider> findByDepartmentId(Long departmentId);
    List<Provider> findByPracticeId(Long practiceId);

    // You can add more custom query methods as needed
}
