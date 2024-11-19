package com.green.madang.manager.order.model;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Setter
@Getter
public class OrderGetRes {
    private int orderId;
    private int custId;
    private int selPrice;
    private int bookId;
    private String orderDate;
    private String name;
    private String bookName;

}