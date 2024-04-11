package com.SignUp.Service;

import com.SignUp.Model.User;
import com.SignUp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User addUser(User user){
        user.setUserID(UUID.randomUUID().toString().split("-")[0]);
        return userRepo.save(user);
    }
}
