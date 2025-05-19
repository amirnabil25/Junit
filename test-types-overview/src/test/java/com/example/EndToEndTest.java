package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EndToEndTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Repository repository;
    @Autowired
    private BusinessService businessService;


    @Test
    void fullRequestCycleTest() throws Exception {
        int a = 2;
        int b = 3;
        mockMvc.perform(get("/multiply")
                        .param("a", String.valueOf(a))
                        .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));

        // Verify side effect in DB
        Integer record = repository.getMultiplier();
        assertEquals(2, record);

        // Verify side effect in Service
        Integer result = businessService.multiply(a, b);
        assertEquals(6, result);

    }
}
