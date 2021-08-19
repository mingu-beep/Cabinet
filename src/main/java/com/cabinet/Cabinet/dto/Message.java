package com.cabinet.Cabinet.dto;


public class Message {
    // alert 창에 보여줄 메세지를 담는 객체
    String message = ""; // 뿌릴 메세지 내용
    String href = ""; // 이동할 화면

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Message() {
    }

    public Message(String message, String href) {
        this.message = message;
        this.href = href;
    }
}
