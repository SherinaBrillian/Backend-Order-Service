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
import com.sherina.hajidanumroh.orderservice.dto.request.CartJamaahRequest;
import com.sherina.hajidanumroh.orderservice.model.CartJamaahModel;
import com.sherina.hajidanumroh.orderservice.repository.CartJamaahRepo;


@Service
public class CartJamaahImplRepo implements CartJamaahRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(CartJamaahRequest cartModel) {
        UUID cartUid = UUID.randomUUID();
        cartModel.setCartJamaahUid(cartUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {
                cartModel.getCartJamaahUid(),
                cartModel.getCustomerUid(),
                cartModel.getNamaJamaah(),
                cartModel.getBin(),
                cartModel.getNamaBin(),
                cartModel.getNomorPorsiHaji(),
                cartModel.getAsalDaerah(),
                cartModel.getKloter(),
                cartModel.getNoHp(),
                cartModel.getEmail()

        };
        jdbcTemplate.update(Constant.CartJamaah.INSERT_DATA, queryParam);
    }


    @Override
    public void deleteData(String uid) {
        Object[] queryParam = new Object[] {uid};
        jdbcTemplate.update(Constant.CartJamaah.DELETE_DATA, queryParam);
    }


    @Override
    public void deleteByCustomer(String customerUid) {
        Object[] queryParam = new Object[] {customerUid};
        jdbcTemplate.update(Constant.CartJamaah.DELETE_BY_CUSTOMER, queryParam);
    }

    @Override
    public List<CartJamaahModel> getAll() {
        List<CartJamaahModel> data = jdbcTemplate.query(Constant.CartJamaah.GET_ALL, new CartJamaahListExtractor());
        return data;
    }

    @Override
    public List<CartJamaahModel> getByFilter(String uid) {
        Object[] queryParam = new Object[] {uid};
        List<CartJamaahModel> data = jdbcTemplate.query(Constant.CartJamaah.GET_BY_FILTER, new CartJamaahListExtractor(), queryParam);
        return data;
    }
    //EXTRACTOR
    public static final class CartJamaahListExtractor implements ResultSetExtractor<List<CartJamaahModel>> {
        @Override
        public List<CartJamaahModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<CartJamaahModel> data = new ArrayList<>();
            while (rs.next()) {
                CartJamaahModel cartModel = new CartJamaahModel();
                cartModel.setAsalDaerah(rs.getString("asalDaerah"));
                cartModel.setBin(rs.getString("bin"));
                cartModel.setCartJamaahUid(rs.getString("cartJamaahUid"));
                cartModel.setEmail(rs.getString("email"));
                cartModel.setKloter(rs.getString("kloter"));
                cartModel.setNamaBin(rs.getString("namaBin"));
                cartModel.setNamaJamaah(rs.getString("namaJamaah"));
                cartModel.setNoHp(rs.getString("noHp"));
                cartModel.setNomorPorsiHaji(rs.getString("nomorPorsiHaji"));
                cartModel.setCustomerUid(rs.getString("customerUid"));
                cartModel.setCreatedAt(rs.getString("createdAt"));
                cartModel.setUpdatedAt(rs.getString("updatedAt"));
                data.add(cartModel);
            }
            return data;
            
        }
    }

}
