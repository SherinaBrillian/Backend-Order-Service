package com.sherina.hajidanumroh.orderservice.repository;

import java.util.List;

import com.sherina.hajidanumroh.orderservice.dto.CartResponseModel;
import com.sherina.hajidanumroh.orderservice.dto.request.CartRequest;

public interface CartRepo {
    void saveData(CartRequest cartModel);
    void updateData(CartRequest cartModel);
    void deleteData(String cartUid);
    List<CartResponseModel> getAll();
    CartResponseModel getById(String cartUid);
    
}
