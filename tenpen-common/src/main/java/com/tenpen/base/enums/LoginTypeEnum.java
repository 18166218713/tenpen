package com.tenpen.base.enums;

/**
 *
 * Created by x00376013 on 2019/9/25.
 */
public enum LoginTypeEnum {
    MOBILE("1","手机用户"),
    ACCOUNT("2","账号登录"),
    WECHAT("3","微信用户"),
    ALIPLAY("4","支付宝用户");

    private String type;
    private String desc;

    LoginTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static boolean isContains(String type) {
        for (LoginTypeEnum typeEnum : LoginTypeEnum.values()) {
            if (typeEnum.getType().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
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
