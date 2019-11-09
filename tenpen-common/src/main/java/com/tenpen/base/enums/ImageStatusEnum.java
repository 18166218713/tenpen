package com.tenpen.base.enums;

public enum ImageStatusEnum {
    EFFECTIVE("1", "有效"),
    INVALID("2", "无效");

    private String status;
    private String desc;

    ImageStatusEnum(String status, String desc) {
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
