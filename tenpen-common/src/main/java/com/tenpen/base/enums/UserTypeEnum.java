package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/25.
 */
public enum UserTypeEnum {
    ORDINARY("1","普通会员"),
    RECHARGE ("2","充值会员");


    private String type;
    private String desc;

    UserTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
