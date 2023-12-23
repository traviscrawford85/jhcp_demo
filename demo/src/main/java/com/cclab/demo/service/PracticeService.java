package com.cclab.demo.service;

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

    public List<Practice> findAll() {
        return practiceRepository.findAll();
    }

    public Practice findById(Long id) {
        return practiceRepository.findById(id).orElse(null); // Consider throwing an exception or
    }

    public Practice save(Practice practice) {
        return practice;
    }

    public void delete(Long id) {
    }
}