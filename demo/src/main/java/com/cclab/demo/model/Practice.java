package com.cclab.demo.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long practice_id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private boolean isAcceptingNewPatients;

    private String name; // Example: Clinic Name, Hospital Name
    private String address;

    @OneToMany(mappedBy = "practice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provider> providers = new ArrayList<>();

    public void setId(Long id) {
    }

    // Constructors, Getters, and Setters

}
