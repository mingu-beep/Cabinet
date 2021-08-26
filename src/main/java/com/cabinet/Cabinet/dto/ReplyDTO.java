package com.cabinet.Cabinet.dto;

import java.util.Date;

public class ReplyDTO {
    private int replyNo;
    private int bdNo;
    private String replyContent;
    private String replyWriter;
    private Date regDate;

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
    }

    public int getBdNo() {
        return bdNo;
    }

    public void setBdNo(int bdNo) {
        this.bdNo = bdNo;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyWriter() {
        return replyWriter;
    }

    public void setReplyWriter(String replyWriter) {
        this.replyWriter = replyWriter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
