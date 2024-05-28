package com.SignUp.Controller;
import com.SignUp.Model.User;
import com.SignUp.Service.UserService;
import com.SignUp.Producer.RabbitMQProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class SignUpControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private SignUpController signUpController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(signUpController).build();
    }

    @Test
    void createUser_InvalidInput_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(post("/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"lo\", \"username\": \"lol\", \"password\": \"lol\", \"email\": \"john@example.com\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createUser_InvalidUsername_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(post("/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John\", \"username\": \"lol?\", \"password\": \"password1\", \"email\": \"john@example.com\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createUser_InvalidPassword_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(post("/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John\", \"username\": \"john123\", \"password\": \"lolololololololo\", \"email\": \"john@example.com\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createUser_InvalidEmail_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(post("/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John\", \"username\": \"john123\", \"password\": \"password1\", \"email\": \"invalidemail\"}"))
                .andExpect(status().isBadRequest());
    }
}
