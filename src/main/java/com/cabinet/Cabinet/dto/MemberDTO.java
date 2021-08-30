package com.cabinet.Cabinet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberDTO {

    private int memNo;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min=6, message = "6자 이상을 입력해주세요.")
    private String memID;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 8자 이상으로 입력해주세요.")
    private String memPW;

    @NotBlank(message = "이름을 입력해주세요.")
    private String memName;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String memEmail;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String memPhone;

    @NotBlank(message = "주소를 입력해주세요.")
    private String memAdrs;

    @NotBlank(message = "생년월일을 입력해주세요.")
    private String memBday;

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getMemPW() {
        return memPW;
    }

    public void setMemPW(String memPW) {
        this.memPW = memPW;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public String getMemAdrs() {
        return memAdrs;
    }

    public void setMemAdrs(String memAdrs) {
        this.memAdrs = memAdrs;
    }

    public String getMemBday() {
        return memBday;
    }

    public void setMemBday(String memBday) {
        this.memBday = memBday;
    }
}
