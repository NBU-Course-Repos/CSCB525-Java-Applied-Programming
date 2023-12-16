package com.example.transportcompany;

import com.example.transportcompany.persistence.model.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

public class RequestSummary {

    public Long requestId;

    public UUID clientId;

    public String companyName;

    public String origin;

    public String destination;

    public Date departureDate;

    public RequestStatus status;

    public RequestType requestType;

    public Date arrivalDate;

    public BigDecimal freightWeight;

    public Short peopleTransported;

    public Invoice invoice;

    public RequestSummary(Request request) {
        this.requestId = request.getRequestId();
        this.companyName = request.getCompany().getName();
        this.clientId = request.getClient().getClientId();
        this.invoice = request.getInvoice();
        this.destination = request.getDestination();
        this.origin = request.getOrigin();
        this.departureDate = request.getDepartureDate();
        this.arrivalDate = request.getArrivalDate();
        this.status = request.getStatus();
        this.requestType = request.getRequestType();
    }
}
