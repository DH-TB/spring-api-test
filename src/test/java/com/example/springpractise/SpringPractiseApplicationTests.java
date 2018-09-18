package com.example.springpractise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringPractiseApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void should_test_api_return_map() throws Exception {
        ResultActions perform = mockMvc.perform(get("/api/map"));
        perform.andExpect(status().isOk());
        perform.andDo(print());
        perform.andExpect(jsonPath("$.key").value("value"));
    }

    @Test
    void should_test_api_return_list() throws Exception {
        ResultActions perform = mockMvc.perform(get("/api/list"));
        perform.andExpect(status().isOk());
        perform.andDo(print());
        
    }
}
