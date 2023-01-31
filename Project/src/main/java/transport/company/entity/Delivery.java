package transport.company.entity;

import jakarta.persistence.*;
import transport.company.dao.DAO;
import transport.company.dao.DeliveryDAO;
import transport.company.exceptions.TransportingZeroPeople;
import transport.company.exceptions.EntityAttributeNull;
import transport.company.exceptions.NullWeightOnCargo;

import java.time.LocalDate;

@Entity
@Table(name="delivery")
public class Delivery {

    public static class Builder{
        private Integer passengersCount;
        private Double distance;
        private Customer customer;
        private Double perPersonRate = 15.4;
        private Double perKgRate = 5.99;
        private Company company;
        private String origin;
        private String destination;
        private LocalDate originDate;
        private LocalDate destinationDate;
        private DeliveryOf delivery;
        private Double weight;
        private Double price;

        public Builder passengerCount(Integer passengersCount){
            this.passengersCount = passengersCount;
            return this;
        }
        public Builder distance(Double distance){
            this.distance = distance;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }
        public Builder setPerPersonRate(Double price){
            this.perPersonRate = price;
            return this;
        }

        public Builder setPerKgRate(Double price){
            this.perKgRate = price;
            return this;
        }

        public Builder company(Company company){
            this.company = company;
            return this;
        }

        public Builder origin(String origin){
            this.origin = origin;
            return this;
        }

        public Builder destination(String destination){
            this.destination = destination;
            return this;
        }

        public Builder originDate(LocalDate originDate){
            this.originDate = originDate;
            return this;
        }

        public Builder destinationDate(LocalDate destinationDate){
            this.destinationDate = destinationDate;
            return this;
        }

        public Builder delivery(DeliveryOf delivery){
            this.delivery = delivery;
            return this;
        }

        public Builder weight(Double weight){
            this.weight = weight;
            return this;
        }

        public Builder price(Double price){
            this.price = price;
            return this;
        }
        private void validateDelivery(Delivery del) throws NullWeightOnCargo, EntityAttributeNull, TransportingZeroPeople {
            if (del.delivery == DeliveryOf.CARGO && del.weight == null) throw new NullWeightOnCargo();
            else if (del.delivery == DeliveryOf.PEOPLE && del.passengersCount < 1) throw new TransportingZeroPeople();
            if (distance == null) throw new EntityAttributeNull("distance");
            else if (origin == null)  throw new EntityAttributeNull("origin");
            else if (originDate == null) throw new EntityAttributeNull("originDate");
            else if (destination == null) throw new EntityAttributeNull("destination");
            else if (destinationDate == null) throw new EntityAttributeNull("destinationDate");
            else if (delivery == null) throw new EntityAttributeNull("delivery");
        }
        public Delivery build(){
            Delivery del = new Delivery(this);
            try {
                validateDelivery(del);
                }
            catch (NullWeightOnCargo exception){
                System.out.println(exception);
            }
            catch (EntityAttributeNull exception){
                System.out.println(exception);
            }
            catch (TransportingZeroPeople exception){
                System.out.println(exception);
            }
            return del;
        }
    }

    public Delivery() {}

    private Delivery(Builder deliveryBuilder){
        this.passengersCount = deliveryBuilder.passengersCount;
        this.customer = deliveryBuilder.customer;
        this.distance = deliveryBuilder.distance;
        this.company = deliveryBuilder.company;
        this.origin = deliveryBuilder.origin;
        this.originDate = deliveryBuilder.originDate;
        this.destination = deliveryBuilder.destination;
        this.destinationDate = deliveryBuilder.destinationDate;
        this.delivery = deliveryBuilder.delivery;
        this.weight = deliveryBuilder.weight;
        this.perPersonRate = deliveryBuilder.perPersonRate;
        this.perKgRate = deliveryBuilder.perKgRate;

        if (delivery == DeliveryOf.CARGO && weight!=null){
            this.price = weight*perKgRate;
        }
        else if (delivery == DeliveryOf.PEOPLE){
            this.price = this.perPersonRate * this.passengersCount;
        }
        try{
            System.out.println("Printing price: ");
            System.out.println(this.price);
            this.price += 0.33*distance;
            System.out.println("Printing price again: ");
            System.out.println(this.price);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Column(name = "isPayed")
    private boolean isPayed = false;

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    @Transient
    private Double perKgRate;

    @Transient
    private Double perPersonRate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="passengers_count", nullable = true)
    private Integer passengersCount;

    @Column(name="distance", nullable = false)
    private Double distance;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Company company;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name="origin_date", nullable = false)
    private LocalDate originDate;

    @Column(name="destination", nullable = false)
    private String destination;

    @Column(name="destination_date", nullable = false)
    private LocalDate destinationDate;

    @Column(name="delivery", nullable = false)
    private DeliveryOf delivery;

    @Column(name="weight", nullable = true)
    private Double weight = null;

    @Column(name="price", nullable = false)
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(Integer passengersCount) {
        this.passengersCount = passengersCount;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOriginDate() {
        return originDate;
    }

    public void setOriginDate(LocalDate originDate) {
        this.originDate = originDate;
    }

    public LocalDate getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(LocalDate destinationDate) {
        this.destinationDate = destinationDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getOriginLocalDate() {
        return originDate;
    }

    public void setOriginLocalDate(LocalDate originDate) {
        this.originDate = originDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDestinationLocalDate() {
        return destinationDate;
    }

    public void setDestinationLocalDate(LocalDate destinationDate) {
        this.destinationDate = destinationDate;
    }

    public DeliveryOf getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryOf delivery) {
        this.delivery = delivery;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void newDelivery(Company company){
        this.setCompany(company);
        DAO<Delivery> deliveryDAO = new DeliveryDAO();
        deliveryDAO.add(this);
        company.addDelivery(this);
        customer.addDelivery(this);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "perKgRate=" + perKgRate +
                ", perPersonRate=" + perPersonRate +
                ", id=" + id +
                ", passengersCount=" + passengersCount +
                ", distance=" + distance +
                ", customer=" + customer +
                ", company=" + company +
                ", origin='" + origin + '\'' +
                ", originDate=" + originDate +
                ", destination='" + destination + '\'' +
                ", destinationDate=" + destinationDate +
                ", delivery=" + delivery +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
