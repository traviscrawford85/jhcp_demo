package com.cclab.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "credentials")
    private Set<Provider> providers;

    // Constructors, Getters, and Setters
    public Credential() {}
    public Credential(String name) { this.name = name; }
    public Credential(String name, Set<Provider> providers) {
        this.name = name;
        this.providers = providers;
    }

}
