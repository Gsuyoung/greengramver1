package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int insCustomer(CustomerPostReq p);
    List<CustomerGetRes> SelCustomerList(CustomerGetReq p); //<무조건 Res> (무조건 Req)
    int updCustomer(CustomerPutReq p);
    int delCustomer(int custId);
}