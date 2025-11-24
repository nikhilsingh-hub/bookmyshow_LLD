package com.LLD.BookMyShow.Services.Implementations;

import com.LLD.BookMyShow.Models.User;
import com.LLD.BookMyShow.Repository.UserRepository;
import com.LLD.BookMyShow.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String email, String mobile) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}
