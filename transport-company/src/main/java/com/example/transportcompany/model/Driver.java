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

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "Specialisations",
            joinColumns = @JoinColumn(name = "unified_civil_number"))
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

    protected Driver() {
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
