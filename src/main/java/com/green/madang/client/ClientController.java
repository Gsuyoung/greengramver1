package com.green.madang.client;

import com.green.madang.client.model.OrderGetReq;
import com.green.madang.client.model.OrderGetRes;
import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.CustomerPostReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {
    public final ClientService service;

    // @ResponseBody -- RestController를 사용하므로 생략가능
    @PostMapping("order")
    @Operation(summary = "책 주문")
    public MyResponse<Integer> insOrders(@RequestBody OrderPostReq p) { //Json형태로 넘어오기때문에 RequestBody를 사용한다.
        int result = service.insOrders(p);
        return new MyResponse<> ("주문이 완료되었습니다.", result);
    }

    //본인이 주문한 책 리스트
    @GetMapping("order")
    @Operation(summary = "책 주문 리스트")
    public MyResponse<List<OrderGetRes>> selOrderList(@ParameterObject @ModelAttribute OrderGetReq p) {
        List<OrderGetRes> list = service.selOrderList(p);
        return new MyResponse<>(list.size() + " rows ", list );
    }



}
