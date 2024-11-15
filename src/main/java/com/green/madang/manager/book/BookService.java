package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //빈등록 : Service 객체 생성
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper; //DI(주소값) 를 받기위해서

    public int postBook(BookPostReq p) {
        return mapper.insBook(p);
    }

    public List<BookGetRes> getBookList(BookGetReq p) {
        // sIdx값 세팅
        int page = p.getPage();
        int size = p.getSize();
        int sIdx = (page -1 ) * size;
       p.setStartIdx(sIdx);
       // p.setSIdx(p.getPage() - 1) * p.getSize()); 위에 네줄을 한줄로 바꾼 경우

        return mapper.selBookList(p);
    }

    public int updBook(BookPutReq p) {
        return mapper.updBook(p);
    }

    public int delBook(BookDelReq p) {
        return mapper.delBook(p);
    }
}
