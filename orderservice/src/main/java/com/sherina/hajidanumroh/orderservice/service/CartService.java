package com.sherina.hajidanumroh.orderservice.service;

import com.sherina.hajidanumroh.orderservice.dto.request.CartRequest;
import com.sherina.hajidanumroh.orderservice.dto.response.CartDataResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.CartListResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.WebResponseBase;

public interface CartService {
    WebResponseBase saveData(CartRequest cartModel);
    WebResponseBase updateData(CartRequest cartModel);
    WebResponseBase deleteData(String cartUid);
    CartListResponse getAll();
    CartDataResponse getById(String cartUid);
}
