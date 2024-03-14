package com.sherina.hajidanumroh.orderservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.orderservice.dto.CartResponseModel;
import com.sherina.hajidanumroh.orderservice.dto.request.CartRequest;
import com.sherina.hajidanumroh.orderservice.dto.response.CartDataResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.CartListResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.orderservice.repository.impl.CartImplRepo;
import com.sherina.hajidanumroh.orderservice.service.CartService;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartImplRepo cartRepo;

    @Override
    public WebResponseBase saveData(CartRequest cartModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            cartRepo.saveData(cartModel);
            response.setStatus("OK");
            return response;
        } catch(DuplicateKeyException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cart is already exist");
        }
    }

    @Override
    public WebResponseBase updateData(CartRequest cartModel) {
        WebResponseBase response = new WebResponseBase();
        cartRepo.updateData(cartModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String cartUid) {
        WebResponseBase response = new WebResponseBase();
        cartRepo.deleteData(cartUid);
        response.setStatus("OK");
        return response;
    }

    @Override
    public CartListResponse getAll() {
        CartListResponse response = new CartListResponse();
        List<CartResponseModel> cartModel = cartRepo.getAll();
        response.setStatus("OK");
        response.setData(cartModel);
        return response;
    }

    @Override
    public CartDataResponse getById(String cartUid) {
        CartDataResponse response = new CartDataResponse();
        CartResponseModel cartModel = cartRepo.getById(cartUid);
        if(cartModel == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart Not Found!");
        }
        response.setStatus("OK");
        response.setData(cartModel);
        return response;
    }
    
}
