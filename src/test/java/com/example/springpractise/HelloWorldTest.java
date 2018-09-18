package com.example.springpractise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class HelloWorldTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = standaloneSetup(new HelloController()).build();
    }

    @Test
    void should() throws Exception {
        ResultActions perform = mockMvc.perform(get("/api/hello"));

        perform.andExpect(status().isOk());
        perform.andDo(print());

        String contentAsString = perform.andReturn().getResponse().getContentAsString();
        assertEquals("hello", contentAsString);

        perform.andExpect(content().string("hello"));
    }
}