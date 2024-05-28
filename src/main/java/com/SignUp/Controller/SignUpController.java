package com.SignUp.Controller;

import com.SignUp.Model.User;
import com.SignUp.Producer.RabbitMQProducer;
import com.SignUp.Service.UserService;
import jakarta.validation.Valid;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signUp")
@Validated
public class SignUpController {
    @Autowired
    private UserService userService;

    private RabbitMQProducer producer;

    public SignUpController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user){
        user.setName(Encode.forHtml(user.getName()));
        user.setUsername(Encode.forHtml(user.getUsername()));
        producer.sendMessage(user.getName());
        return userService.addUser(user);
    }
}
