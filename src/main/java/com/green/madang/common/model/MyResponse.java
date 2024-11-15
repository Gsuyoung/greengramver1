package com.green.madang.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 응답할 때 사용하는 객체
@Setter
@Getter
@AllArgsConstructor //모든 아규먼트를 사용할 수 있는 생성자를 만들어 준다.(모든 멤버필드 초기화 할 수 있는 생성자 생성)
public class MyResponse<T> {
    private String resultMessage;
    private T resultData;
}
