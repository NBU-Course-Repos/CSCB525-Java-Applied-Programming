package com.example.transportcompany.persistence;

import com.example.transportcompany.AbstractTest;
import com.example.transportcompany.persistence.model.*;
import com.example.transportcompany.persistence.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.util.List;

import com.example.transportcompany.persistence.model.Request.BadRequetPropertyException;

import static org.assertj.core.api.Assertions.*;

/**
 * A class that defines the necessary tests for {@link RequestService}
 */
public class TestRequestService extends AbstractTest implements ModelServiceTest {

    @Test
    public void create() {
        assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() ->
                        requestService.save(new Request()))
                .withMessageContaining("not-null property references a null or transient value");

        try {
            Request request = requestService.save(buildTestRequest("Pernik", false));
            assertThat(request.getRequestId()).isNotNull();
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void read() {
        try {
            Request request = requestService.save(buildTestRequest("Pernik", false));
            Request request2 = requestService.save(buildTestRequest("Pernik", false));
            assertThat(requestService.getById(request.getRequestId())).isPresent();
            assertThat(requestService.getAll().size()).isEqualTo(2);
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void update() {
        try {
            Request request = requestService.save(buildTestRequest("Pernik", false));
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
    public void delete() {
        try {
            Request request = requestService.save(buildTestRequest("Pernik", false));
            assertThat(requestService.getById(request.getRequestId())).isPresent();

            requestService.delete(request);
            assertThat(requestService.getById(request.getRequestId())).isEmpty();
        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void payInvoice() {
        try {
            Request request = requestService.save(buildTestRequest("Pernik", false));
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
    public void orderAndFilterByDestination() {
        try {
            Request request1 = requestService.save(buildTestRequest("Ahtopol", false));
            Request request2 = requestService.save(buildTestRequest("Botevgrad", false));
            Request request3 = requestService.save(buildTestRequest("Asenovgrad", false));
            Request request4 = requestService.save(buildTestRequest("Asenovgrad", false));

            List<Request> filter1 = requestService.orderAllByDestination();
            assertThat(filter1.stream().map(Request::getRequestId))
                    .containsExactly(
                            request1.getRequestId(),
                            request3.getRequestId(),
                            request4.getRequestId(),
                            request2.getRequestId());

            List<Request> filter2 = requestService.findAllBy("Asenovgrad");
            assertThat(filter2).hasSize(2);
            assertThat(filter2.stream().map(Request::getRequestId))
                    .contains(request3.getRequestId(), request4.getRequestId());

        } catch (BadRequetPropertyException exception) {
            fail(exception.getMessage());
        }
    }
}