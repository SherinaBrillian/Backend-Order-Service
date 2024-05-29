package com.sherina.hajidanumroh.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private String customerUid;
    private UserModel user;
    private String address;
    private String statusUid;
    private String pihkKbihu;
    private String notes;
    private UserModel verifiedBy;
    private String verifiedAt;
    private String userImage;
    private String verifyImage;
    private String dirImage;
    private String createdAt;
    private String updatedAt;
    private UserModel createdBy;
}
