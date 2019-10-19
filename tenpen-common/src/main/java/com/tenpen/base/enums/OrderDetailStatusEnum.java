package com.tenpen.base.enums;

public enum OrderDetailStatusEnum {
    NOPLAY("0", "未结算"),
    PAID("1", "已支付"),
    RECEIVED("2", "已收货"),
    DONE("3", "已完成"),
    EXCEPTION("4", "异常处理");

    private String status;
    private String desc;

    OrderDetailStatusEnum(String status, String desc) {
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
