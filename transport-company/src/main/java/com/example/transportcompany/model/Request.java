package com.example.transportcompany.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Company company;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "departure_date")
    private LocalDateTime departureDate;

    @Column(nullable = false)
    @Enumerated
    private RequestStatus status = RequestStatus.TRIAGE;

    @Column(nullable = false)
    @Enumerated
    private RequestType requestType;

    @Temporal(TemporalType.DATE)
    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;


    @Column(name = "freight_weight")
    private BigDecimal freightWeight;

    @Column(name = "people_transported")
    private Short peopleTransported;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "invoice_paid", referencedColumnName = "is_paid"),
            @JoinColumn(name = "invoice_price", referencedColumnName = "price")
    })
    private Invoice invoice;

    public Request() {
    }

    private Request(RequestBuilder builder) {
        this.company = builder.company;
        this.client = builder.client;
        this.requestType = builder.requestType;
        this.status = builder.status;
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.arrivalDate = builder.arrivalDate;
        this.departureDate = builder.departureDate;
        this.freightWeight = builder.freightWeight;
        this.peopleTransported = builder.peopleTransported;
    }

    public Request(Client client, Company company, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, RequestStatus status, RequestType requestType, BigDecimal freightWeight, Short peopleTransported, Invoice invoice) {
        this.client = client;
        this.company = company;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.status = status;
        this.requestType = requestType;
        this.freightWeight = freightWeight;
        this.peopleTransported = peopleTransported;
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setRequestType(RequestType requestFor) {
        this.requestType = requestFor;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Client getClient() {
        return client;
    }

    public Company getCompany() {
        return company;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public static class RequestBuilder {
        private LocalDateTime arrivalDate;
        private RequestType requestType;
        private RequestStatus status = RequestStatus.TRIAGE;
        private LocalDateTime departureDate;
        private String destination;
        private String origin;
        private Company company;
        private Client client;
        private BigDecimal freightWeight;
        private Short peopleTransported;

        public RequestBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public RequestBuilder company(Company company) {
            this.company = company;
            return this;
        }

        public RequestBuilder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public RequestBuilder destination(String destination) {
            this.destination = destination;
            return this;
        }

        public RequestBuilder freightWeight(BigDecimal freightWeight) throws Exception {
            if (this.peopleTransported != null || this.requestType == RequestType.CHAUFFEUR)
                throw new Exception("Can not set freight weight when transporting people.");

            this.freightWeight = freightWeight;
            return this;
        }

        public RequestBuilder peopleTransported(Short peopleTransported) throws Exception {
            if (this.freightWeight != null || this.requestType == RequestType.FREIGHT)
                throw new Exception("Can not set amount of people transported when transporting freight.");

            this.peopleTransported = peopleTransported;
            return this;
        }

        public RequestBuilder arrivalDate(LocalDateTime arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        public RequestBuilder requestType(RequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public RequestBuilder status(RequestStatus status) {
            this.status = status;
            return this;
        }

        public RequestBuilder departureDate(LocalDateTime departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
