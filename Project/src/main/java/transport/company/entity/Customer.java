package transport.company.entity;
import jakarta.persistence.*;
import transport.company.dao.DAO;
import transport.company.dao.DeliveryDAO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "customer")
    private List<Delivery> deliveries;

    @ManyToMany
    @JoinTable(name = "company_customer")
    private List<Company> companies;

    public void newDelivery(Company com, Delivery del){
        del.newDelivery(com);
    }
    public Customer() {
        deliveries = new ArrayList<>();
        companies = new ArrayList<>();
    }

    public void pay(Delivery delivery){
        if (delivery.getCustomer() == this && !delivery.isPayed()){
            delivery.setPayed(true);
            delivery.getCompany().addToEarnings(delivery.getPrice());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> delivery) {
        this.deliveries = delivery;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> company) {
        this.companies = company;
    }

    public void removeCompany(Company company){
        this.companies.remove(company);
    }
    public void addDelivery(Delivery delivery){
        this.deliveries.add(delivery);
    }
    public void addCompany(Company company){
        this.companies.add(company);
    }
}
