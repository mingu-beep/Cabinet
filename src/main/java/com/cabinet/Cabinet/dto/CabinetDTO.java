package com.cabinet.Cabinet.dto;

public class CabinetDTO {
    private int cnNo;
    private String cnLo;
    private String cnPW;
    private boolean cnExist;
    private String cnReser;

    public int getCnNo() {
        return cnNo;
    }

    public void setCnNo(int cnNo) {
        this.cnNo = cnNo;
    }

    public String getCnLo() {
        return cnLo;
    }

    public void setCnLo(String cnLo) {
        this.cnLo = cnLo;
    }

    public String getCnPW() {
        return cnPW;
    }

    public void setCnPW(String cnPW) {
        this.cnPW = cnPW;
    }

    public boolean isCnExist() {
        return cnExist;
    }

    public void setCnExist(boolean cnExist) {
        this.cnExist = cnExist;
    }

    public String getCnReser() {
        return cnReser;
    }

    public void setCnReser(String cnReser) {
        this.cnReser = cnReser;
    }
}
