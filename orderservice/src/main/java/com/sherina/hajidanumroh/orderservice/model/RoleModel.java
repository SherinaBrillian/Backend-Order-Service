package com.sherina.hajidanumroh.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleModel {
    private String roleUid;

    private String roleDesc;

    private String statusUid;
}
