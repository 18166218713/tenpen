package com.tenpen.base.enums;

/**
 * 订单状态
 * Created by x00376013 on 2019/9/27.
 */
public enum OrderStatusEnum {
    SUBMIT("1", "已提交"),
    NOPAY("2", "未支付"),
    PAID("3", "已支付"),
    SHIPPED("4", "已发货"),
    DONE("5", "已完成"),
    COMPLAINT("6", "投诉");

    private String status;
    private String desc;

    OrderStatusEnum(String status, String desc) {
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
