package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FunctionalTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldMultiplyTwoNumbers_correctly() throws Exception {
        mockMvc.perform(get("/multiply?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }
}
