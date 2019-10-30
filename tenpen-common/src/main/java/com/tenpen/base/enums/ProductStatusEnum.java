package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/27.
 */
public enum ProductStatusEnum {
    LOCK("-1","锁定"),
    OBTAINED("0","下架"),
    DRAF("1","草稿"),
    PENDING("2","待审核"),
    PASSED("3","审核通过"),
    PUBLISHED("4","已发布"),
    PAID("5","已支付"),
    SHIPPED("6","已发货"),
    DONE("7","已完成");

    private String status;
    private String desc;

    ProductStatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
