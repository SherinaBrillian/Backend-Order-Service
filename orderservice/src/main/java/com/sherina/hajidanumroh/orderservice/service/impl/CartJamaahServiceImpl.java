package com.sherina.hajidanumroh.orderservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.orderservice.constant.UrlConstants;
import com.sherina.hajidanumroh.orderservice.dto.CartJamaahResponseModel;
import com.sherina.hajidanumroh.orderservice.dto.request.CartJamaahRequest;
import com.sherina.hajidanumroh.orderservice.dto.response.CartJamaahListResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.CustomerResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.WebResponseAdd;
import com.sherina.hajidanumroh.orderservice.model.CartJamaahModel;
import com.sherina.hajidanumroh.orderservice.repository.CartJamaahRepo;
import com.sherina.hajidanumroh.orderservice.service.CartJamaahService;


@Service
public class CartJamaahServiceImpl implements CartJamaahService {
    @Autowired
    CartJamaahRepo cartJamaahRepo;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public WebResponseAdd saveData(CartJamaahRequest cartModel) {
        try {
            WebResponseAdd response = new WebResponseAdd();
            cartJamaahRepo.saveData(cartModel);

            response.setStatus("ok");
            response.setData(cartModel.getCartJamaahUid());
            return response;
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Jamaah sudah ada");
        }
    }

    @Override
    public WebResponseAdd deleteData(String uid) {
        WebResponseAdd response = new WebResponseAdd();
        cartJamaahRepo.deleteData(uid);
        response.setStatus("ok");
        response.setData(uid);
        return response;
    }

    @Override
    public WebResponseAdd deleteByCustomer(String customerUid) {
        WebResponseAdd response = new WebResponseAdd();
        cartJamaahRepo.deleteByCustomer(customerUid);
        response.setStatus("ok");
        response.setData(customerUid);
        return response;
    }

    @Override
    public CartJamaahListResponse getAll() {
        CartJamaahListResponse response = new CartJamaahListResponse();
        List<CartJamaahResponseModel> cartModelList = new ArrayList<>();
        List<CartJamaahModel> cartModels = cartJamaahRepo.getAll();
        for (final CartJamaahModel cartModel : cartModels) {
            CustomerResponse customerResp = restTemplate.getForObject(UrlConstants.Customer.GET_CUSTOMER,
                    CustomerResponse.class, Map.of("customerUid", cartModel.getCustomerUid()));

            CartJamaahResponseModel cartResponseModel = new CartJamaahResponseModel();
            cartResponseModel.setAsalDaerah(cartModel.getAsalDaerah());
            cartResponseModel.setBin(cartModel.getBin());
            cartResponseModel.setCartJamaahUid(cartModel.getCartJamaahUid());
            cartResponseModel.setEmail(cartModel.getEmail());
            cartResponseModel.setKloter(cartModel.getKloter());
            cartResponseModel.setNamaBin(cartModel.getNamaBin());
            cartResponseModel.setNamaJamaah(cartModel.getNamaJamaah());
            cartResponseModel.setNoHp(cartModel.getNoHp());
            cartResponseModel.setNomorPorsiHaji(cartModel.getNomorPorsiHaji());
            cartResponseModel.setCustomer(customerResp.getData());
            cartResponseModel.setCreatedAt(cartModel.getCreatedAt());
            cartResponseModel.setUpdatedAt(cartModel.getCreatedAt());

            cartModelList.add(cartResponseModel);
        }
        response.setStatus("OK");
        response.setData(cartModelList);
        return response;
    }

    @Override
    public CartJamaahListResponse getByFilter(String uid) {
        CartJamaahListResponse response = new CartJamaahListResponse();
        List<CartJamaahResponseModel> cartModelList = new ArrayList<>();

        CustomerResponse customerResp = restTemplate.getForObject(UrlConstants.Customer.GET_CUSTOMER,
                CustomerResponse.class, Map.of("customerUid", uid));

        if (customerResp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customerUid " + uid + " tidak ditemukan!");
        } else {
            List<CartJamaahModel> cartModels = cartJamaahRepo.getByFilter(uid);

            for (final CartJamaahModel cartModel : cartModels) {

                CartJamaahResponseModel cartResponseModel = new CartJamaahResponseModel();
                cartResponseModel.setAsalDaerah(cartModel.getAsalDaerah());
                cartResponseModel.setBin(cartModel.getBin());
                cartResponseModel.setCartJamaahUid(cartModel.getCartJamaahUid());
                cartResponseModel.setEmail(cartModel.getEmail());
                cartResponseModel.setKloter(cartModel.getKloter());
                cartResponseModel.setNamaBin(cartModel.getNamaBin());
                cartResponseModel.setNamaJamaah(cartModel.getNamaJamaah());
                cartResponseModel.setNoHp(cartModel.getNoHp());
                cartResponseModel.setNomorPorsiHaji(cartModel.getNomorPorsiHaji());
                cartResponseModel.setCustomer(customerResp.getData());
                cartResponseModel.setCreatedAt(cartModel.getCreatedAt());
                cartResponseModel.setUpdatedAt(cartModel.getCreatedAt());

                cartModelList.add(cartResponseModel);
            }
            response.setStatus("OK");
            response.setData(cartModelList);
            return response;
        }
    }

}
