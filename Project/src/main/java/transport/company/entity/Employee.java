package transport.company.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", unique = true)
    private String name;

    @Column(name="salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @ManyToMany
    private List<Qualification> qualifications;

    public Employee() {
    }
    public Employee(String name, Company company, Double salary) {
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    public void addQualification(Qualification skill){
        if (!qualifications.contains(skill)){
            qualifications.add(skill);
        }
    }
    public void removeQualification(Qualification skill){
        qualifications.remove(skill);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }
}
