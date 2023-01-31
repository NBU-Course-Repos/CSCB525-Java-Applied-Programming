package transport.company.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {

    public Company(){}

    public Company(String name) {
        this.name = name;
        customers = new ArrayList<>();
        deliveries = new ArrayList<>();
        employees = new HashSet<>();
        vehicles = new ArrayList<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @OneToMany (mappedBy = "company")
    private List<Vehicle> vehicles;

    @OneToMany (mappedBy = "company")
    private Set<Employee> employees;

    @OneToMany (mappedBy = "company")
    private List<Delivery> deliveries;

    @Column(name = "earnings")
    private Double earnings = 0.0;

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    @ManyToMany (mappedBy = "companies")
    private List<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
    public void addDelivery(Delivery delivery){
        this.deliveries.add(delivery);
    }
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
    public void removeCustomer(Customer customer){
        this.customers.remove(customer);
    }
    public void removeDelivery(Delivery delivery){
        this.deliveries.remove(delivery);
    }
    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
    public void removeEmployee(Employee employee){
        this.employees.remove(employee);
    }
    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }
    public void addToEarnings(Double amount){
        earnings += amount;
    }
}
