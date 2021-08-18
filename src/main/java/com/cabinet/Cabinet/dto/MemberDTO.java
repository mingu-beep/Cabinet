package com.cabinet.Cabinet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private String memID;
    private String memPw;
    private String memName;
    private String memEmail;
    private String memPhone;
    private String memAdrs;
    private String memBday;
    
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
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
