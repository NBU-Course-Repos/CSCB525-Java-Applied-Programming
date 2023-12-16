package com.example.transportcompany.persistence;

import com.example.transportcompany.persistence.model.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestClientService extends AbstractServiceTest {
    private final String CUSTOMER_FN = "Ivan";
    private final String CUSTOMER_LN = "Ivanov";
    private final String CUSTOMER_EMAIL = "ivan.ivanov@abv.bg";
    private final String CUSTOMER_PN = "+3934132121";

    @Test
    void create() {
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
    void read() {
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
    void update() {
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
    void delete() {
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
