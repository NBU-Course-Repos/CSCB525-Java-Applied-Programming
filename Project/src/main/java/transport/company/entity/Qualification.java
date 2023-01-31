package transport.company.entity;

import jakarta.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    List<Employee> employees;

    @Enumerated(EnumType.STRING)
    private QualificationType type;

    public Qualification(List<Employee> employees, QualificationType type) {
        this.employees = employees;
        this.type = type;
    }

    public Qualification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public QualificationType getType() {
        return type;
    }

    public void setType(QualificationType type) {
        this.type = type;
    }
}
