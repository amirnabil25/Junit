package com.example;

import com.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class IntegrationTest {
    @Autowired
    private UserRepository repository;

    @Test
    void testSave() {
        User user = User.builder().firstName("Alice").build();

        User savedUser = repository.save(user);


        assertThat(user).isNotNull();
        Assertions.assertNotNull(savedUser.getId());
    }
}
