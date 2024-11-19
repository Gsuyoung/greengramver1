package com.green.madang.manager.customer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerGetRes { //Res의 커리문의 결과를 담을 친구 (응답)
    private int custId;
    private String name;
    private String address;
    private String phone;
}