package com.cabinet.Cabinet.dto;

import java.util.Date;

public class ProductDTO {

    private int pdNo;
    private int ctNo;
    private int bdNo;
    private int pdPrice;
    private int dealType;
    private String pdName;
    private String memID;
    private String location;
    private String pdImg;
    private Date pdUpDate;

    public int getPdNo() {
        return pdNo;
    }

    public void setPdNo(int pdNo) {
        this.pdNo = pdNo;
    }

    public Date getPdUpDate() {
        return pdUpDate;
    }

    public void setPdUpDate(Date pdUpDate) {
        this.pdUpDate = pdUpDate;
    }

    public String getPdImg() {
        return pdImg;
    }

    public void setPdImg(String pdImg) {
        this.pdImg = pdImg;
    }

    public int getBdNo() {
        return bdNo;
    }

    public void setBdNo(int bdNo) {
        this.bdNo = bdNo;
    }

    public int getCtNo() {
        return ctNo;
    }

    public void setCtNo(int ctNo) {
        this.ctNo = ctNo;
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

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
