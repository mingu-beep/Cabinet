package com.cabinet.Cabinet.dto;

import java.util.Date;

public class CsDTO {
    private int csNo;
    private String memID;
    private String csTitle;
    private String csContent;
    private Date csDate;
    private int csCom;

    public Date getCsDate() {
        return csDate;
    }

    public void setCsDate(Date csDate) {
        this.csDate = csDate;
    }

    public int getCsNo() {
        return csNo;
    }

    public void setCsNo(int csNo) {
        this.csNo = csNo;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getCsTitle() {
        return csTitle;
    }

    public void setCsTitle(String csTitle) {
        this.csTitle = csTitle;
    }

    public String getCsContent() {
        return csContent;
    }

    public void setCsContent(String csContent) {
        this.csContent = csContent;
    }

    public int getCsCom() {
        return csCom;
    }

    public void setCsCom(int csCom) {
        this.csCom = csCom;
    }
}
