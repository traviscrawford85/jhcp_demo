package com.cclab.demo.repository;

import com.cclab.demo.model.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Long> {
    // Custom query methods if needed
    List<Practice> findByName(String name);

    List<Practice> findByDepartmentId(Long id);
    List<Practice> findByIsAcceptingNewPatients(Boolean isAcceptingNewPatients);

}
