package com.cabinet.Cabinet.dto;

import java.util.Date;

public class BoardVO
{
    private int bdNo;
    private String ctNo;
    private String bdTitle;
    private String bdContent;
    private String memID;
    private String memName;
    private Date writeDate;
    private int bdView;
    private int pdPrice;
    private int dealType;
    private String pdName;
    private String location;
    private String pdImg;
    private Date pdUpDate;

    public int getBdNo() {
        return bdNo;
    }

    public void setBdNo(int bdNo) {
        this.bdNo = bdNo;
    }

    public String getCtNo() {
        return ctNo;
    }

    public void setCtNo(String ctNo) {
        this.ctNo = ctNo;
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

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public int getBdView() {
        return bdView;
    }

    public void setBdView(int bdView) {
        this.bdView = bdView;
    }

    public int getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(int pdPrice) {
        this.pdPrice = pdPrice;
    }

    public int getDealType() {
        return dealType;
    }

    public void setDealType(int dealType) {
        this.dealType = dealType;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPdImg() {
        return pdImg;
    }

    public void setPdImg(String pdImg) {
        this.pdImg = pdImg;
    }

    public Date getPdUpDate() {
        return pdUpDate;
    }

    public void setPdUpDate(Date pdUpDate) {
        this.pdUpDate = pdUpDate;
    }
}
