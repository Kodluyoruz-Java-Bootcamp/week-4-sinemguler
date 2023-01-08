package com.emlakcepteservice.converter;

import com.emlakcepteservice.model.User;
import com.emlakcepteservice.request.UserRequest;
import com.emlakcepteservice.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserResponse convert(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setName(user.getName());
        user.setType(user.getType());
        return response;
    }

    public User convert(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setCreateDate(LocalDateTime.now());
        user.setType(userRequest.getType());
        return user;
    }

    public List<UserResponse> convert(List<User> userList) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : userList) {
            userResponses.add(convert(user));
        }

        // userList.stream().forEach(user -> userResponses.add(convert(user)));

        return userList.stream().map(this::convert).toList();

        // return userResponses;
    }
}
