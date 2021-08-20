package com.cabinet.Cabinet.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

	private String bdTitle;
	private String bdContent;

	private String writer;
	private Date writeDate;

	private MultipartFile bdImg;

	public MultipartFile getBdImg() {
		return bdImg;
	}

	public void setBdImg(MultipartFile bdImg) {
		this.bdImg = bdImg;
	}

	public String getBdTitle() {
		return bdTitle;
	}

	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}

	public String getBdContent() {
		return bdContent;
	}

	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
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
