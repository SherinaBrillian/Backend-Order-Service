package com.sherina.hajidanumroh.orderservice.repository;

import java.util.List;

import com.sherina.hajidanumroh.orderservice.dto.request.CartJamaahRequest;
import com.sherina.hajidanumroh.orderservice.model.CartJamaahModel;


public interface CartJamaahRepo {
    void saveData(CartJamaahRequest cartModel);
    void deleteData(String uid);
    void deleteByCustomer(String customerUid);
    List<CartJamaahModel> getAll();
    List<CartJamaahModel> getByFilter(String cartUid);
    
}
