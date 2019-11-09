package com.tenpen.base.enums;

public enum PhotoStatusEnum {

    DELETE("-1", "已删除"),
    DRAF("1", "草稿"),
    PENDING("2", "待审核"),
    PASSED("3", "审核通过"),
    PUBLISHED("4", "已发布");

    private String status;
    private String desc;

    PhotoStatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
