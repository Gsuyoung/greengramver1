package com.green.madang.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderPostReq {
    private int custId;
    private int bookId;
}