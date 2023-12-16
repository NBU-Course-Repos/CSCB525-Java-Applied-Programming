package com.example.transportcompany;

import com.example.transportcompany.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
            Request request = requestService.save(buildTestRequest("Pernik"));
            assertThat(request.getRequestId()).isNotNull();
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void read() {
        try {
            Request request = requestService.save(buildTestRequest("Pernik"));
            Request request2 = requestService.save(buildTestRequest("Pernik"));
            assertThat(requestService.getById(request.getRequestId())).isPresent();
            assertThat(requestService.getAll().size()).isEqualTo(2);
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void update() {
        try {
            Request request = requestService.save(buildTestRequest("Pernik"));
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
            Request request = requestService.save(buildTestRequest("Pernik"));
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
            Request request = requestService.save(buildTestRequest("Pernik"));
            assertThat(request.getInvoice().getIsPaid()).isFalse();
            requestService.payInvoice(request);

            Request updatedRequest = requestService.getById(request.getRequestId()).get();
            Invoice paidInvoice = updatedRequest.getInvoice();
            assertThat(paidInvoice.getIsPaid()).isTrue();

            assertThat(BigDecimal.valueOf(0).add(paidInvoice.getPrice()))
                    .isEqualTo(updatedRequest.getCompany().getEarnings());

        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void orderAndFilterByDestination() {
        try {
            Request request1 = requestService.save(buildTestRequest("Ahtopol"));
            Request request2 = requestService.save(buildTestRequest("Botevgrad"));
            Request request3 = requestService.save(buildTestRequest("Asenovgrad"));
            Request request4 = requestService.save(buildTestRequest("Asenovgrad"));

            List<Request> filter1 = requestService.orderAllByDestination();
            assertThat(filter1.stream().map(Request::getRequestId))
                    .containsExactly(
                            request1.getRequestId(),
                            request3.getRequestId(),
                            request4.getRequestId(),
                            request2.getRequestId());

            List<Request> filter2 = requestService.findAllByDestination("Asenovgrad");
            assertThat(filter2).hasSize(2);
            assertThat(filter2.stream().map(Request::getRequestId))
                    .contains(request3.getRequestId(), request4.getRequestId());

        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    private Request buildTestRequest(String destination) throws BadRequetPropertyException {
        return new Request.RequestBuilder()
                .client(clientService.save(new Client("a", "a", "123", "a@a.a")))
                .company(companyService.save(new Company("Speedn't")))
                .origin("Sofia")
                .destination(destination)
                .departureDate(Date.valueOf(LocalDate.now()))
                .status(RequestStatus.TRIAGE)
                .requestType(RequestType.FREIGHT)
                .freightWeight(BigDecimal.valueOf(100))
                .invoice(new Invoice(BigDecimal.valueOf(110), false))
                .build();
    }
}