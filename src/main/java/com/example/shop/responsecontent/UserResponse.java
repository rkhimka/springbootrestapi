package com.example.shop.responsecontent;

import com.example.shop.models.common.ResponseData;
import com.example.shop.models.users.User;
import com.example.shop.models.users.UsersList;

import java.util.List;

public final class UserResponse {
    public static final String INVALID_PARAMS = "Invalid param is used";
    public static final String UNKNOWN_EXCEPTION = "Something went wrong";
    public static final String USER_ALREADY_EXISTS = "User with name %s is already registered";
    public static final String USER_SUCCESSFULLY_REMOVED = "User %s was removed successfully";
    public static final String USER_NOT_FOUND = "There is no such user id";

    private UserResponse() {
    }

    public static ResponseData okContent(List<User> availableUsers) {
        return ResponseData
                .builder()
                .data(UsersList.builder()
                        .users(availableUsers)
                        .count(availableUsers.size())
                        .build())
                .build();
    }
}
