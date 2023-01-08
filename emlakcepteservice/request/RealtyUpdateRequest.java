package com.emlakcepteservice.request;

import com.emlakcepteservice.model.enums.RealtyType;

public class RealtyUpdateRequest {
    private int id;
    private Integer no;
    private String title;
    private String province;
    private RealtyType status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public RealtyType getStatus() {
        return status;
    }

    public void setStatus(RealtyType status) {
        this.status = status;
    }
}
