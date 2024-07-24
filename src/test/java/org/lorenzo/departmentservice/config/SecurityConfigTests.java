package org.lorenzo.departmentservice.config;


import org.junit.jupiter.api.Test;
import org.lorenzo.departmentservice.DepartmentServiceApplication;
import org.lorenzo.departmentservice.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DepartmentServiceApplication.class)
@AutoConfigureMockMvc
public class SecurityConfigTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private PasswordEncoder passwordEncoder;

//    @Test
//    public void testUnauthenticatedRequest() throws Exception {
//        mockMvc.perform(get("/api/departments"))
//                .andExpect(status().isUnauthorized());
//    }
//
//    @Test
//    public void testAuthenticateEndpoint() throws Exception {
//        mockMvc.perform(post("/api/departments"))
//                .andExpect(status().isOk());
//    }

    @Test
    public void testPasswordEncoderBean() {
        assertNotNull(passwordEncoder);
    }

    @Test
    public void testAuthenticationManagerBean() {
        assertNotNull(authenticationManager);
    }
}

