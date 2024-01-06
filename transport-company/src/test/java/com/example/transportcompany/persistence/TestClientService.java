package com.example.transportcompany.persistence;

import com.example.transportcompany.AbstractTest;
import com.example.transportcompany.persistence.model.Client;
import com.example.transportcompany.persistence.service.ClientService;
import com.example.transportcompany.persistence.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A class that defines the necessary tests for {@link ClientService}
 */
public class TestClientService extends AbstractTest implements ModelServiceTest {
    private final String CUSTOMER_FN = "Ivan";
    private final String CUSTOMER_LN = "Ivanov";
    private final String CUSTOMER_EMAIL = "ivan.ivanov@abv.bg";
    private final String CUSTOMER_PN = "+3934132121";

    @Test
    public void create() {
        Client client = clientService.save(clientService.save(new Client(
                        CUSTOMER_FN,
                        CUSTOMER_LN,
                        CUSTOMER_PN,
                        CUSTOMER_EMAIL)
                )
        );
        assertThat(client.getClientId()).isNotNull();
    }

    @Test
    public void read() {
        Client client = clientService.save(clientService.save(new Client(
                        CUSTOMER_FN,
                        CUSTOMER_LN,
                        CUSTOMER_PN,
                        CUSTOMER_EMAIL)
                )
        );
        Client client2 = clientService.save(clientService.save(new Client(
                        "Petar",
                        "Petrov",
                        "+3132312312",
                        "asdfs@ads.ree")
                )
        );
        assertThat(clientService.getById(client.getClientId())).isPresent().get()
                .hasFieldOrPropertyWithValue("firstName", CUSTOMER_FN);
        assertThat(clientService.getAll().size()).isEqualTo(2);
    }

    @Test
    public void update() {
        Client client = clientService.save(clientService.save(new Client(
                        CUSTOMER_FN,
                        CUSTOMER_LN,
                        CUSTOMER_PN,
                        CUSTOMER_EMAIL)
                )
        );
        assertThat(clientService.getById(client.getClientId())).isPresent().get()
                .hasFieldOrPropertyWithValue("firstName", CUSTOMER_FN);

        client.setLastName("Georgiev");
        clientService.update(client);
        assertThat(clientService.getById(client.getClientId())).isPresent().get()
                .hasFieldOrPropertyWithValue("lastName", "Georgiev");
    }

    @Test
    public void delete() {
        Client client = clientService.save(clientService.save(new Client(
                        CUSTOMER_FN,
                        CUSTOMER_LN,
                        CUSTOMER_PN,
                        CUSTOMER_EMAIL)
                )
        );
        assertThat(clientService.getById(client.getClientId())).isPresent();
        clientService.delete(client);
        assertThat(clientService.getById(client.getClientId())).isEmpty();
    }
}
