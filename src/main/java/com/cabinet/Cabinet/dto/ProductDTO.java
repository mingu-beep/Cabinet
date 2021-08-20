package com.cabinet.Cabinet.dto;

import java.util.Date;

public class ProductDTO {

    private int ctNo;

    private int pdPrice;
    private int dealType;
    private String pdName;
    private String memID;
    private String location;

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
