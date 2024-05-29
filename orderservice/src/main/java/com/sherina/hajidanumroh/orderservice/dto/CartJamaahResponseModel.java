package com.sherina.hajidanumroh.orderservice.dto;

import com.sherina.hajidanumroh.orderservice.model.CustomerModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartJamaahResponseModel {
    private String cartJamaahUid;
    private CustomerModel customer;
    private String namaJamaah;
    private String bin;
    private String namaBin;
    private String nomorPorsiHaji;
    private String asalDaerah;
    private String kloter;
    private String noHp;
    private String email;
    private String createdAt;
    private String updatedAt;
}
