package com.green.madang.manager.customer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerPutReq {
    @Schema(title = "고객ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int custId;
    @Schema(title = "고객 이름", example = "홍길동")
    private String name;
    @Schema(title = "고객 주소", example = "대구 달서구")
    private String address;
    @Schema(title = "고객 번호", example = "010-0000-0000")
    private String phone;
}