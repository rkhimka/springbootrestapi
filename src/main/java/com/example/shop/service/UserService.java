package com.example.shop.service;

import com.example.shop.entities.UserEntity;
import com.example.shop.exceptions.UserAlreadyExistsException;
import com.example.shop.exceptions.UserNotFoundException;
import com.example.shop.models.common.ResponseData;
import com.example.shop.models.users.User;
import com.example.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.shop.responsecontent.UserResponse.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User create(UserEntity user) throws UserAlreadyExistsException {
        String userName = user.getUserName();
        List<UserEntity> userEntities = new ArrayList<>();
        userRepository.findAll().forEach(userEntities::add);
        List<String> userNames = userEntities.stream().map(UserEntity::getUserName).collect(Collectors.toList());
        if (userNames.contains(userName)) {
            throw new UserAlreadyExistsException(String.format(USER_ALREADY_EXISTS, userName));
        }
        userRepository.save(user);
        return User.toUserModel(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        } else {
            return User.toUserModel(userRepository.findById(id).get());
        }
    }

    public ResponseData getList() {
        List<UserEntity> userEntities = new ArrayList<>();
        userRepository.findAll().forEach(userEntities::add);
        List<User> users = userEntities.stream().map(User::toUserModel).collect(Collectors.toList());
        return okContent(users);
    }

    public Long delete(Long id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        } else {
            userRepository.deleteById(id);
            return id;
        }
    }

}
