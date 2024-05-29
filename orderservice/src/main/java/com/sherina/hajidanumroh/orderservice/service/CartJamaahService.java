package com.sherina.hajidanumroh.orderservice.service;

import com.sherina.hajidanumroh.orderservice.dto.request.CartJamaahRequest;
import com.sherina.hajidanumroh.orderservice.dto.response.CartJamaahListResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.WebResponseAdd;

public interface CartJamaahService {
    WebResponseAdd saveData(CartJamaahRequest cartModel);
    WebResponseAdd deleteData(String uid);
    WebResponseAdd deleteByCustomer(String customerUid);
    CartJamaahListResponse getAll();
    CartJamaahListResponse getByFilter(String uid);
}
