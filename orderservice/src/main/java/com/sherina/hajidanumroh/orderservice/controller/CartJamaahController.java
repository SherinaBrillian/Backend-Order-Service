package com.sherina.hajidanumroh.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherina.hajidanumroh.orderservice.dto.request.CartJamaahRequest;
import com.sherina.hajidanumroh.orderservice.dto.response.CartJamaahListResponse;
import com.sherina.hajidanumroh.orderservice.dto.response.WebResponseAdd;
import com.sherina.hajidanumroh.orderservice.service.impl.CartJamaahServiceImpl;


@RestController
@RequestMapping("api/v1/cartJamaah")
public class CartJamaahController {
    @Autowired
    CartJamaahServiceImpl cartRepo;

    @PostMapping
    public WebResponseAdd saveData(@RequestBody CartJamaahRequest cartModel) {
        return cartRepo.saveData(cartModel);
    }

    @DeleteMapping
    @RequestMapping("/delete/{uid}")
    public WebResponseAdd deleteData(@PathVariable String uid) {
        return cartRepo.deleteData(uid);
    }

    @DeleteMapping
    @RequestMapping("/deleteByCustomer/{customerUid}")
    public WebResponseAdd deleteByCustomer(@PathVariable String customerUid) {
        return cartRepo.deleteByCustomer(customerUid);
    }

    @GetMapping
    public CartJamaahListResponse getAll() {
        return cartRepo.getAll();
    }

    @GetMapping
    @RequestMapping("/filter/{uid}")
    public CartJamaahListResponse getByFilter(@PathVariable String uid) {
        return cartRepo.getByFilter(uid);
    }
}
