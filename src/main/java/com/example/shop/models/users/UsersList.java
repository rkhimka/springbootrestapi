package com.example.shop.models.users;

import com.example.shop.models.common.ResponseDataField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersList extends ResponseDataField {
    private List<User> users;
    private Integer count;
}
