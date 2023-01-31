package transport.company.entity;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "company", nullable = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    public Vehicle(Company company, VehicleType type) {
        this.id = id;
        this.company = company;
        this.type = type;
        company.addVehicle(this);
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
