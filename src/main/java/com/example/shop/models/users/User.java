package com.example.shop.models.users;

import com.example.shop.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String userName;

    public static User toUserModel(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setUserName(userEntity.getUserName());
        return model;
    }
}
