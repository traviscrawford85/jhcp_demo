package com.cclab.demo.controller;

import com.cclab.demo.model.Practice;
import com.cclab.demo.service.PracticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/practices")
public class PracticeController {
    private final PracticeService practiceService;

    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @GetMapping
    public List<Practice> getAllPractices() {
        return practiceService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable Long id) {
        Optional<Practice> practice = Optional.ofNullable(practiceService.findById(id));
        return practice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Practice createPractice(@RequestBody Practice practice) {
        return practiceService.save(practice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practice> updatePractice(@PathVariable Long id, @RequestBody Practice practice) {
        Optional<Practice> existingPractice = Optional.ofNullable(practiceService.findById(id));
        if (existingPractice.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        practice.setId(id);
        return ResponseEntity.ok(practiceService.save(practice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractice(@PathVariable Long id) {
        Optional<Practice> practice = Optional.ofNullable(practiceService.findById(id));
        if (practice.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        practiceService.delete(id);
        return ResponseEntity.ok().build();
    }


}
