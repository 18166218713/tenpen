package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/25.
 */
public enum UserStatusEnum {
    NORMAL("0","正常"),
    LOCKED("1","锁定"),
    ABNORMAL("-1","异常");

    private String status;
    private String desc;

    UserStatusEnum(String status, String desc) {
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
