package com.tapusd.librarymanagement.controller;

import com.tapusd.librarymanagement.domain.enumeration.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AdminControllerTest {

    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    void getAdminHomePage() throws Exception {
       mockMvc.perform(get("/admin"))
               .andExpect(status().isOk());
    }

    @Test
    void getAdminHomePageTestUnauthenticatedUserTest() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void getAdminDetailsTestUnauthorized() throws Exception {
        final String username = "test";
        mockMvc.perform(get("/admin/details")
                        .with(user(username)))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void getAdminDetailsTestAuthorized() throws Exception {
        final String username = "test";
        mockMvc.perform(get("/admin/details")
                        .with(user(username).roles(Role.ADMIN.name())))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello " + username));
    }

}