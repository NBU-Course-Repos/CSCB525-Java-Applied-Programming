package com.example.transportcompany;

import com.example.transportcompany.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import com.example.transportcompany.model.Request.BadRequetPropertyException;

import static org.assertj.core.api.Assertions.*;

public class TestRequestService extends AbstractServiceTest {

    @Test
    void create() {
        assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() ->
                        requestService.save(new Request()))
                .withMessageContaining("not-null property references a null or transient value");

        try {
            Request request = requestService.save(buildTestRequest());
            assertThat(request.getRequestId()).isNotNull();
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void read() {
        try {
            Request request = requestService.save(buildTestRequest());
            Request request2 = requestService.save(buildTestRequest());
            assertThat(requestService.getById(request.getRequestId())).isPresent();
            assertThat(requestService.getAll().size()).isEqualTo(2);
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void update() {
        try {
            Request request = requestService.save(buildTestRequest());
            assertThat(requestService.getById(request.getRequestId())).isPresent();
            assertThat(requestService.getById(request.getRequestId()).get().getStatus()).isEqualTo(RequestStatus.TRIAGE);

            request.setStatus(RequestStatus.DELIVERY);
            requestService.update(request);
            assertThat(requestService.getById(request.getRequestId()).get().getStatus()).isEqualTo(RequestStatus.DELIVERY);
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void delete() {
        try {
            Request request = requestService.save(buildTestRequest());
            assertThat(requestService.getById(request.getRequestId())).isPresent();

            requestService.delete(request);
            assertThat(requestService.getById(request.getRequestId())).isEmpty();
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void payInvoice() {
        try {
            Request request = requestService.save(buildTestRequest());
            assertThat(request.getInvoice().getIsPaid()).isFalse();
            requestService.payInvoice(request);

            Invoice paidInvoice = requestService.getById(request.getRequestId()).get().getInvoice();
            assertThat(paidInvoice.getIsPaid()).isTrue();

        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    private Request buildTestRequest() throws BadRequetPropertyException {
        return new Request.RequestBuilder()
                .client(clientService.save(new Client("a", "a", "123", "a@a.a")))
                .company(companyService.save(new Company("Speedn't")))
                .origin("Sofia")
                .destination("Pernik")
                .departureDate(Date.valueOf(LocalDate.now()))
                .status(RequestStatus.TRIAGE)
                .requestType(RequestType.FREIGHT)
                .freightWeight(BigDecimal.valueOf(100))
                .invoice(new Invoice(BigDecimal.valueOf(110), false))
                .build();
    }
}