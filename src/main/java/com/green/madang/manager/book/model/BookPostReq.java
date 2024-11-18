package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
// 입고할 때(bookId는 들어가지 않는다.)
public class BookPostReq {
    @Schema(title = "도서 이름", description = "설명할거 있으면 적으면 된다.")
    private String bookName; // {} 멤버필드명이랑 같아야한다.
    @Schema(title = "출판사 이름") //requiredMode = Schema.RequiredMode.REQUIRED --> 필수조건 나타낼때
    private String publisher;
    @Schema(title = "도서 가격")
    private int price;
}
