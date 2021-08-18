package com.cabinet.Cabinet.dto;

import java.sql.Date;

public class MemberDTO {

    int mem_no;
    String mem_id;
    String mem_pw;
    String mem_name;
    Date mem_bday;
    String mem_gender;
    String mem_email;
    String mem_phone;
    String mem_adrs;
    int post_cnt;
    int q_cnt;

    public int getMem_no() {
        return mem_no;
    }

    public void setMem_no(int mem_no) {
        this.mem_no = mem_no;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public Date getMem_bday() {
        return mem_bday;
    }

    public void setMem_bday(Date mem_bday) {
        this.mem_bday = mem_bday;
    }

    public String getMem_gender() {
        return mem_gender;
    }

    public void setMem_gender(String mem_gender) {
        this.mem_gender = mem_gender;
    }

    public String getMem_email() {
        return mem_email;
    }

    public void setMem_email(String mem_email) {
        this.mem_email = mem_email;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    public void setMem_phone(String mem_phone) {
        this.mem_phone = mem_phone;
    }

    public String getMem_adrs() {
        return mem_adrs;
    }

    public void setMem_adrs(String mem_adrs) {
        this.mem_adrs = mem_adrs;
    }

    public int getPost_cnt() {
        return post_cnt;
    }

    public void setPost_cnt(int post_cnt) {
        this.post_cnt = post_cnt;
    }

    public int getQ_cnt() {
        return q_cnt;
    }

    public void setQ_cnt(int q_cnt) {
        this.q_cnt = q_cnt;
    }
}
