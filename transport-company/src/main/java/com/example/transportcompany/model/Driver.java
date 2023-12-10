package com.example.transportcompany.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Driver {

    @Id
    @Column(name = "unified_civil_number")
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID UCN;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @ManyToOne
    @JoinColumn(nullable = false)
    Company employer;

    @OneToOne
    @JoinColumn
    Vehicle vehicle;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable
    Set<Specialisation> specialisations = Set.of(Specialisation.DEFAULT);

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    public void addSpecialisation(Specialisation spec) {
        specialisations.add(spec);
    }

    public Driver() {
    }

    public Driver(String firstName, String lastName, Company employer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employer = employer;
    }

    public UUID getUCN() {
        return UCN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Company getEmployer() {
        return employer;
    }

    public Set<Specialisation> getSpecialisations() {
        return specialisations;
    }
}
