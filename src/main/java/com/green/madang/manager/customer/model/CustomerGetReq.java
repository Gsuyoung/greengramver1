package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerGetReq { // 요청
    @Schema(description = "page값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;
    @JsonIgnore
    private int startIdx; //(page - 1) * size 프론트에서 존재자체를 알 필요 없다.
    @Schema(description = "검색타입: {name, address, phone}중 한 값을 보낸다.", example = "name")
    private String searchType;
    @Schema(description = "검색내용", example = "ani")
    private String searchText;
}
