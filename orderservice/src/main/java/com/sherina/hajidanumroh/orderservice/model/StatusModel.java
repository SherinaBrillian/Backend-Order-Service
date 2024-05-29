package com.sherina.hajidanumroh.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusModel {
    private String statusUid;
    private String statusDesc;
    private ServicesModel service;
    private String isActive;
}
