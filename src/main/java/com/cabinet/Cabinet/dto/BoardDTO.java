package com.cabinet.Cabinet.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

    private int bdNo;
	private String ctNo;
	private String bdTitle;
	private String bdContent;
	private String memID;
	private String memName;
	private Date writeDate;
	private String bdImg;
	private int bdView;
	private String Keyword;
	Map<String,Object> map = new HashMap<String,Object>();
	
	public int getBdView() {
		return bdView;
	}

	public void setBdView(int bdView) {
		this.bdView = bdView;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}
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

	public String getKeyword() {
		return Keyword;
	}

	public void setKeyword(String Keyword) {
		this.Keyword = Keyword;
	}
	
	public Map<String,Object> getMap() {
		return map;
	}
}
