package com.example.transportcompany;

import com.example.transportcompany.persistence.model.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Fail.fail;
import static org.assertj.core.api.Assertions.assertThat;

public class TestFilePersistence extends AbstractTest {

    @Test
    void requestsDataFilePersistence() throws IOException {
        bulkPersistRequests();
        List<Request> requests = requestService.getAll();
        File file = JsonUtils.requestsToJson(requests);
        assertThat(file).exists();

    }

    private void bulkPersistRequests() {
        List<String> destinations = List.of("Pernik", "Sofia", "Vienna", "Belgrade");

        IntStream.range(0, 3).forEachOrdered(n -> {
            try {
                requestService.save(buildTestRequest(destinations.get(n)));
            } catch (Request.BadRequetPropertyException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
