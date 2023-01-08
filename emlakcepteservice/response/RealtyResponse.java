package com.emlakcepteservice.response;

import com.emlakcepteservice.model.enums.RealtyType;

public class RealtyResponse {
    private Integer no;
    private String title;
    private RealtyType status;
    private String province;

    private int id;

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

    public RealtyType getStatus() {
        return status;
    }

    public void setStatus(RealtyType status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "RealtyResponse{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", province='" + province + '\'' +
                '}';
    }
}
