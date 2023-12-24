package com.cclab.demo.service;

import com.cclab.demo.handler.ResourceNotFoundException;
import com.cclab.demo.model.Practice;
import com.cclab.demo.repository.PracticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    private final PracticeRepository practiceRepository;

    public PracticeService(PracticeRepository practiceRepository) {
        this.practiceRepository = practiceRepository;
    }

    public Practice savePractice(Practice practice) {
        return practiceRepository.save(practice);
    }

    public List<Practice> getAllPractices() {
        return practiceRepository.findAll();
    }

    public Practice getPracticeById(Long id) {
        return practiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Practice not found with id: " + id));
    }

    public List<Practice> getPracticesByDepartmentId(Long departmentId) {
        // You may need to create this method in your PracticeRepository
        // Orgarization of the method might differ depending on your data model.
        return practiceRepository.findByDepartmentId(departmentId);
    }

    public void deletePractice(Long id) {
        if (practiceRepository.existsById(id)) {
            practiceRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Practice not found with id: " + id);
        }
    }

    public Practice findById(Long id) {
        return practiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Practice not found with id: " + id));
    }

    public List<Practice> findByDepartmentId(Long id) {
        return practiceRepository.findByDepartmentId(id);
    }

    public Practice save(Practice practice) {
        return practiceRepository.save(practice);
    }

    public List<Practice> findAll() {
        return practiceRepository.findAll();
    }
}