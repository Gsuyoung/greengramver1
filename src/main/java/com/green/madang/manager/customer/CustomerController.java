package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/customer")
@Tag(name = "고객", description = "고객 관리")
public class CustomerController {
    public final CustomerService service;

    @PostMapping
    @Operation(summary = "고객 등록")
    public MyResponse<Integer> insCustomer(@RequestBody CustomerPostReq p) {
        int result = service.insCustomer(p);
        return new MyResponse<> ("고객이 등록되었습니다.", result);
    }

    //@ModelAttribute는 여러개의 값을 한번에 다 받을 수 있고
    //@RequestParam은 객체화가 되지않은 값을 하나씩만 받을 수 있다.
    //get방식 , delete방식 --> 쿼리스트링방식
    @GetMapping
    @Operation(summary = "고객 리스트", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    //@ParameterObject - Swagger용 애노테이션, RequestParam으로 설정했을 때 나오는 FORM처럼 되게 한다.
    public MyResponse<List<CustomerGetRes>> SelCustomerList(@ParameterObject @ModelAttribute CustomerGetReq p) {
        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.SelCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    //RequestParam을 이용한 Get방식
    @GetMapping("/param")
    @Operation(summary = "고객 리스트2", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    public MyResponse<List<CustomerGetRes>> SelCustomerList1(@RequestParam int page, @RequestParam int size,
                                                             @RequestParam(name = "search_type", required = false) String searchType,
                                                             @RequestParam(name = "search_text", required = false) String searchText) {
        CustomerGetReq p = new CustomerGetReq(page,size,searchType,searchText);
        p.setPage(page);
        p.setSize(size);
        p.setSearchType(searchType);
        p.setSearchText(searchText);

        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.SelCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    @PutMapping
    @Operation(summary = "고객 리스트")
    public MyResponse<Integer> updCustomer(@RequestBody CustomerPutReq p) {
        int result = service.updCustomer(p);
        return new MyResponse<> ("고객 업데이트 완료", result);
    }

    @DeleteMapping
    @Operation(summary = "고객 삭제")
    public MyResponse<Integer> delCustomer(@RequestParam(value = "cust_id") int custId) {
        int result = service.delCustomer(custId);
        return new MyResponse<> ("고객 삭제 완료", result);
    }
}
