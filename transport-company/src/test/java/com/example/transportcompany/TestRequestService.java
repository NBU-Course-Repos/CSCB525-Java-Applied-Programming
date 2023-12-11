package com.example.transportcompany;

import com.example.transportcompany.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    void read() {

    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }

    private Request buildTestRequest() throws Exception {
        return new Request.RequestBuilder()
                .client(clientService.save(new Client("a", "a", "123", "a@a.a")))
                .company(companyService.save(new Company("Speedn't")))
                .origin("Sofia")
                .destination("Pernik")
                .departureDate(LocalDateTime.now())
                .status(RequestStatus.TRIAGE)
                .requestType(RequestType.FREIGHT)
                .freightWeight(BigDecimal.valueOf(100))
                .build();
    }
}
