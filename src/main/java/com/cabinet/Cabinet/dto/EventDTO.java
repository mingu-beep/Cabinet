package com.cabinet.Cabinet.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDTO {
    private int evtNo;
    private String evtTitle;
    private String evtContent;
    private String evtImg;
    private String evtDate;

    public int getEvtNo() {
        return evtNo;
    }

    public void setEvtNo(int evtNo) {
        this.evtNo = evtNo;
    }

    public String getEvtTitle() {
        return evtTitle;
    }

    public void setEvtTitle(String evtTitle) {
        this.evtTitle = evtTitle;
    }

    public String getEvtContent() {
        return evtContent;
    }

    public void setEvtContent(String evtContent) {
        this.evtContent = evtContent;
    }

    public String getEvtImg() {
        return evtImg;
    }

    public void setEvtImg(String evtImg) {
        this.evtImg = evtImg;
    }

    public String getEvtDate() {
        return evtDate;
    }

    public void setEvtDate(String evtDate) {
        this.evtDate = evtDate;
    }
}
