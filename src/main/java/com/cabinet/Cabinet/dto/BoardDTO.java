package com.cabinet.Cabinet.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BoardDTO {
	
	@NotBlank(message = "제목을 입력해주세요.")
	@Size(min=5, message = "5자 이상을 입력해주세요.")
	private String title;
	
	@NotBlank(message = "내용을 입력해주세요.")
	@Size(max=3000, message = "최대 3000자")
	private String subject;
	
	private String writer;
	private Date writeDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
}
