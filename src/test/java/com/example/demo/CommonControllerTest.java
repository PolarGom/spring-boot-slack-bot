package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 공통 컨트롤러 테스트
 * 
 * @author EDA
 * @since 2021-09-13
 */
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("dev")
//@Transactional
public class CommonControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    protected ObjectMapper jsonObjectMapper;

    @BeforeEach
    public void beforeAll() {

        jsonObjectMapper = new ObjectMapper();

        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .build();
    }

}
