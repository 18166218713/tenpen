package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/25.
 */
public enum DeleteFlagEnum {
    YES("Y", "是"),
    NO("N", "否");

    private String key;
    private String desc;

    DeleteFlagEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
