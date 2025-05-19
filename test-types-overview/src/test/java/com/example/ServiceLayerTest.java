package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ServiceLayerTest {

    @Mock
    private Repository repository;

    @InjectMocks
    private BusinessService businessService;

    @BeforeEach
    void setUp() {
        // Optionally, you can clear the database or set up the repository state here.
    }

    @Test
    void multiply_shouldReturnCorrectResult() {
        // Act
        int result = businessService.multiply(2, 3);

        // Assert
        assertEquals(6, result); // Verifying the business logic in the service layer
    }

    @Test
    void multiply_shouldSaveToRepository() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        businessService.multiply(a, b);

        verify(repository, times(1)).save(eq(6)); // Verifying the repository method interaction
    }
}
