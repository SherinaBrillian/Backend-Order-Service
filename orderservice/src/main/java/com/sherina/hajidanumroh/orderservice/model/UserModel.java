package com.sherina.hajidanumroh.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String userUid;
    private String fullName;
    private String email;
    private RoleModel role;
    private String phone;
    private StatusModel status;
}
