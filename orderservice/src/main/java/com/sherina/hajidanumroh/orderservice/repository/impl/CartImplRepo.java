package com.sherina.hajidanumroh.orderservice.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.sherina.hajidanumroh.orderservice.constant.Constant;
import com.sherina.hajidanumroh.orderservice.dto.CartResponseModel;
import com.sherina.hajidanumroh.orderservice.dto.request.CartRequest;
import com.sherina.hajidanumroh.orderservice.repository.CartRepo;



@Service
public class CartImplRepo implements CartRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(CartRequest cartModel) {
        UUID cartUid = UUID.randomUUID();
        cartModel.setCartUid(cartUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {
            cartModel.getCartUid(), 
            cartModel.getCustomerUid(), 
            cartModel.getProductUid(), 
            cartModel.getPriceUid(),
            cartModel.getQty(),
            cartModel.getServiceUid(),
        };
        jdbcTemplate.update(Constant.Cart.INSERT, queryParam);
    }

    @Override
    public void updateData(CartRequest cartModel) {
        Object[] queryParam = new Object[] {
            cartModel.getCustomerUid(), 
            cartModel.getProductUid(), 
            cartModel.getPriceUid(),
            cartModel.getQty(),
            cartModel.getServiceUid(),
            cartModel.getCartUid(),
        };
        jdbcTemplate.update(Constant.Cart.UPDATE, queryParam);
    }

    @Override
    public void deleteData(String cartUid) {
        Object[] queryParam = new Object[] {cartUid};
        jdbcTemplate.update(Constant.Cart.DELETE, queryParam);
    }

    @Override
    public List<CartResponseModel> getAll() {
        List<CartResponseModel> data = jdbcTemplate.query(Constant.Cart.GET_ALL, new CartListExtractor());
        return data;
    }

    @Override
    public CartResponseModel getById(String cartUid) {
        Object[] queryParam = new Object[] {cartUid};
        CartResponseModel data = jdbcTemplate.query(Constant.Cart.GET_BY_ID, new CartExtractor(), queryParam);
        return data;
    }

    //EXTRACTOR
    public static final class CartListExtractor implements ResultSetExtractor<List<CartResponseModel>> {
        @Override
        public List<CartResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<CartResponseModel> data = new ArrayList<>();
            while (rs.next()) {
                CartResponseModel cartModel = new CartResponseModel();
                cartModel.setCartUid(rs.getString("cartUid"));
                cartModel.setCustomerUid(rs.getString("customerUid"));
                cartModel.setProductUid(rs.getString("productUid"));
                cartModel.setPriceUid(rs.getString("priceUid"));
                cartModel.setQty(rs.getLong("qty"));
                cartModel.setServiceUid(rs.getString("serviceUid"));
                cartModel.setCreatedAt(rs.getString("createdAt"));
                cartModel.setUpdatedAt(rs.getString("updatedAt"));
                data.add(cartModel);
            }
            return data;
            
        }
    }

    public static final class CartExtractor implements ResultSetExtractor<CartResponseModel> {
        @Override
        public CartResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            CartResponseModel cartModel = new CartResponseModel();
            if(rs.next()){
                cartModel.setCartUid(rs.getString("cartUid"));
                cartModel.setCustomerUid(rs.getString("customerUid"));
                cartModel.setProductUid(rs.getString("productUid"));
                cartModel.setPriceUid(rs.getString("priceUid"));
                cartModel.setQty(rs.getLong("qty"));
                cartModel.setServiceUid(rs.getString("serviceUid"));
                cartModel.setCreatedAt(rs.getString("createdAt"));
                cartModel.setUpdatedAt(rs.getString("updatedAt"));

                return cartModel;
            }
            else{
                cartModel = null;
                return cartModel;
            }
            
        }
    }
    
}
