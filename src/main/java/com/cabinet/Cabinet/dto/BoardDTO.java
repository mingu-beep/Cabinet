package com.cabinet.Cabinet.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

	private String ctNo;
	private String bdTitle;
	private String bdContent;
	private String memID;
	private String memName;
	private Date writeDate;
	private String bdImg;


	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getCtNo() {
		return ctNo;
	}

	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
	}

	public String getBdImg() {
		return bdImg;
	}

	public void setBdImg(String bdImg) {
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
}
