package com.cabinet.Cabinet.dto;

// DTO :  Data Transfer Object, 컨트롤러나 매퍼로 주고받는 데이터를 담는 객체\
// DB 내 어떤 데이터를 가져올 것이라고 정의하는 것
// getter setter 가 모두 있어야 오류가 생기지 않는다.
// lombok 사용 가능

public class TestDTO {

    String title;
    String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}