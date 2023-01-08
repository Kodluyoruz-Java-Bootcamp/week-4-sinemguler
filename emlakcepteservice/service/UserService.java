package com.emlakcepteservice.service;

import com.emlakcepteservice.configuration.RabbitMQConfiguration;
import com.emlakcepteservice.controller.UserController;
import com.emlakcepteservice.converter.UserConverter;
import com.emlakcepteservice.model.User;
import com.emlakcepteservice.repository.UserRepository;
import com.emlakcepteservice.request.UserRequest;
import com.emlakcepteservice.request.UserUpdateRequest;
import com.emlakcepteservice.response.UserResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

    public UserResponse createUser(UserRequest userRequest) {
        User savedUser = userRepository.save(converter.convert(userRequest));
        Logger logger = Logger.getLogger(UserController.class.getName());
        logger.log(Level.INFO, "[createUser] - user created: {0}", savedUser.getId());
        rabbitTemplate.convertAndSend(rabbitMQConfiguration.getQueueName(), userRequest);
        return converter.convert(savedUser);
    }

    public List<UserResponse> getAll() {

        return converter.convert(userRepository.findAll());
    }

    public void updatePassword(User user, String newPassword) {
        // önce hangi user bul ve passwordü update et.
    }

    public User getByEmailUntiPattern(String email) {

        //// @formatter:off
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
        // @formatter:on

    }

    public UserResponse getByEmail(String email) {

        return converter.convert(userRepository.findByEmail(email));
    }

    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }

    public UserResponse update(UserUpdateRequest userUpdateRequest) {
        // TODO Auto-generated method stub
        return null;
    }
}
