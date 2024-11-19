package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j //System print 대신 사용하는것
@RestController//응답을 Json 또는 XML 형식으로 변환
@RequiredArgsConstructor // final이 붙은 아규먼트만 생성자를 만들어준다.
@RequestMapping("manager/book")
@Tag(name = "도서", description = "도서 API")
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고", description = "도서 입고 처리 API")
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p) {
        log.info("BookPostReq : {}", p); //system.out.println 대신 사용(오른쪽 p를 문자열로 바꿔서 찍는다.)
        log.warn("warn"); //경고로 뭔가를 남기고 싶을때
        log.error("error"); //에러메세지를 남기고 싶을때(예외처리)

        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description = "도서 정보 리스트<br> 보기 API") //<br> 개행할때 사용
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p) {
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }

    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> updBook(@RequestBody BookPutReq p) {
        int result = service.updBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 업데이트 완료", result);
        return response;
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제")
    public MyResponse<Integer> delBook(BookDelReq p) {
        int result = service.delBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 삭제 완료", result);
        return response;
    }
}