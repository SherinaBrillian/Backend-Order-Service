package com.sherina.hajidanumroh.orderservice.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConstants {
    private static String BASE_URL_PRODUCT;
    private static String BASE_URL_PRICE;
    private static String BASE_URL_STATUS;
    private static String BASE_URL_CUSTOMER;
    private static String BASE_URL_VOUCHER;
    private static String BASE_URL_FEE;
    private static String BASE_URL_BANK;
    private static String BASE_URL_SERVICE;
    private static String BASE_URL_CHAT;
    private static String BASE_URL_ROOM;
    private static String BASE_URL_ATTACHMENT;
    private static String BASE_URL_NOTIF;
    private static String BASE_URL_CONTENTNOTIF;
    private static String BASE_URL_USER;
    private static String BASE_URL_ROLE;

    @Autowired
    public void setBaseUrl
    (@Value("${config.product}")String baseUrlProduct,
    @Value ("${config.price}")String baseUrlPrice,
    @Value ("${config.status}")String baseUrlStatus,
    @Value ("${config.customer}")String baseUrlCustomer,
    @Value ("${config.voucher}")String baseUrlVoucher,
    @Value ("${config.fee}")String baseUrlFee,
    @Value ("${config.bank}")String baseUrlBank,
    @Value ("${config.services}")String baseUrlService,
    @Value ("${config.room}")String baseUrlRoom,
    @Value ("${config.chat}")String baseUrlChat,
    @Value ("${config.attachment}")String baseUrlAttachment,
    @Value ("${config.notif}")String baseUrlNotif,
    @Value ("${config.contentNotif}")String baseUrlContentNotif,
    @Value ("${config.user}")String baseUrlUser,
    @Value ("${config.role}")String baseUrlRole
    ) {
        BASE_URL_PRODUCT = baseUrlProduct;
        BASE_URL_PRICE = baseUrlPrice;
        BASE_URL_STATUS = baseUrlStatus;
        BASE_URL_CUSTOMER = baseUrlCustomer;
        BASE_URL_VOUCHER = baseUrlVoucher;
        BASE_URL_FEE = baseUrlFee;
        BASE_URL_BANK = baseUrlBank;
        BASE_URL_SERVICE = baseUrlService;
        BASE_URL_CHAT = baseUrlChat;
        BASE_URL_ROOM = baseUrlRoom;
        BASE_URL_ATTACHMENT = baseUrlAttachment;
        BASE_URL_NOTIF = baseUrlNotif;
        BASE_URL_CONTENTNOTIF = baseUrlContentNotif;
        BASE_URL_USER = baseUrlUser;
        BASE_URL_ROLE = baseUrlRole;
    }

    public final static class Product {
        private final static String BASE_URL = BASE_URL_PRODUCT;

        public final static String GET_PRODUCT = BASE_URL + "/{productUid}";
    }
    public final static class Price {
        private final static String BASE_URL = BASE_URL_PRICE;

        public final static String GET_PRICE = BASE_URL + "/{priceUid}";
    }
    public final static class Status {
        private final static String BASE_URL = BASE_URL_STATUS;

        public final static String GET_STATUS = BASE_URL + "/{statusUid}";
    }
    public final static class Customer {
        private final static String BASE_URL = BASE_URL_CUSTOMER;

        public final static String GET_CUSTOMER = BASE_URL + "/{customerUid}";
    }
    public final static class Voucher {
        private final static String BASE_URL = BASE_URL_VOUCHER;

        public final static String GET_VOUCHER = BASE_URL + "/{voucherUid}";
    }
    public final static class Fee {
        private final static String BASE_URL = BASE_URL_FEE;

        public final static String GET_FEE = BASE_URL + "/{feeUid}";
    }
    public final static class Bank {
        private final static String BASE_URL = BASE_URL_BANK;

        public final static String GET_BANK = BASE_URL + "/{bankUid}";
    }
    public final static class Service {
        private final static String BASE_URL = BASE_URL_SERVICE;

        public final static String GET_SERVICE = BASE_URL + "/{serviceUid}";
    }
    public final static class Attachment {
        private final static String BASE_URL = BASE_URL_ATTACHMENT;

        public final static String GET_ATTACHMENT = BASE_URL + "/{uid}";
    }
    public final static class Chat {
        private final static String BASE_URL = BASE_URL_CHAT;

        public final static String ADD_CHAT = BASE_URL ;
    }
    public final static class Room {
        private final static String BASE_URL = BASE_URL_ROOM;

        public final static String ADD_ROOM = BASE_URL ;
    }
    public final static class Notif {
        private final static String BASE_URL = BASE_URL_NOTIF;

        public final static String ADD_NOTIF = BASE_URL ;
    }
    public final static class ContentNotif {
        private final static String BASE_URL = BASE_URL_CONTENTNOTIF;

        public final static String ADD_CONTENTNOTIF = BASE_URL ;

        public final static String GET_CONTENT = BASE_URL + "/{uid}";
    }
    public final static class User {
        private final static String BASE_URL = BASE_URL_USER;

        public final static String GET_USER = BASE_URL + "/filter/{uid}";

        public final static String GET_USER_DETAIL = BASE_URL + "/detail/{uid}";
    }
    public final static class Role {
        private final static String BASE_URL = BASE_URL_ROLE;

        public final static String GET_ROLE = BASE_URL + "/{uid}";
    }
}
