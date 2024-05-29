package com.sherina.hajidanumroh.orderservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartJamaahRequest {
    private String cartJamaahUid;
    private String customerUid;
    private String namaJamaah;
    private String bin;
    private String namaBin;
    private String nomorPorsiHaji;
    private String asalDaerah;
    private String kloter;
    private String noHp;
    private String email;
}