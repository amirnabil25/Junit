package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IntegrationTest {
    @Autowired
    private Repository repository;

    @Test
    void testSave() {
        User user = repository.save(new User(1, "Wim"));
        assertThat(user).isNotNull();
    }
}
