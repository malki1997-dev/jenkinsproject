package com.example.malkijenkins;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class CalcSomTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculSomme() throws Exception {
        // Test avec des valeurs positives
        mockMvc.perform(get("/calculate-sum")
                        .param("a", "5")
                        .param("b", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));

        // Test avec des valeurs négatives
        mockMvc.perform(get("/calculate-sum")
                        .param("a", "-3")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("-1"));

        // Test avec des zéros
        mockMvc.perform(get("/calculate-sum")
                        .param("a", "0")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}
