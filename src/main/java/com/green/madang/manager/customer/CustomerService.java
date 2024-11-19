package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;

    public int insCustomer(CustomerPostReq p) {
        return mapper.insCustomer(p);
    }

    public List<CustomerGetRes> SelCustomerList(CustomerGetReq p) {
        //page 로직처리 >> startIdx값 세팅
        int startIdx = ( p.getPage() - 1 ) * p.getSize();
        p.setStartIdx(startIdx);
        return mapper.SelCustomerList(p);
    }

    public int updCustomer(CustomerPutReq p) {
        return mapper.updCustomer(p);
    }

    public int delCustomer(int custId) {
        return mapper.delCustomer(custId);
    }
}