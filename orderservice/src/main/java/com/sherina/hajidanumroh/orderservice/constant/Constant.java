package com.sherina.hajidanumroh.orderservice.constant;

public class Constant {
    public static final class Cart {
        public static final String INSERT = "Insert into tbCart (cartUid, customerUid, productUid, priceUid, qty, serviceUid) value (?,?,?,?,?,?)";
        public static final String UPDATE = "Update tbCart set  customerUid =?, productUid = ?, priceUid = ?, qty = ?, serviceUid = ? where cartUid = ?";
        public static final String DELETE = "Delete from tbCart where cartUid = ?";
        public static final String GET_ALL = "Select * from tbCart";
        public static final String GET_BY_ID = "Select * from tbCart where cartUid = ?";
    }

    public static final class CartJamaah {
        public static final String INSERT_DATA = "insert into tbCartJamaah (cartJamaahUid,customerUid,namaJamaah,bin,namaBin,nomorPorsiHaji,asalDaerah,kloter,noHp,email) values(?,?,?,?,?,?,?,?,?,?)";
        public static final String DELETE_DATA = "delete from tbCartJamaah where cartJamaahUid = ?";
        public static final String DELETE_BY_CUSTOMER = "delete from tbCartJamaah where customerUid = ?";
        public static final String GET_ALL = "select * from tbCartJamaah";
        public static final String GET_BY_FILTER = "select * from tbCartJamaah where customerUid = ?";
    }
}