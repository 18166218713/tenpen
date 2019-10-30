package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/26.
 */
public enum WithdrawTypeEnum {
    WECHAT("1", "微信提现"),
    ALIPLAY("2", "支付宝提现");

    private String key;
    private String value;

    WithdrawTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(String key) {
        for (WithdrawTypeEnum withdrawTypeEnum : WithdrawTypeEnum.values()) {
            if (withdrawTypeEnum.getKey().equalsIgnoreCase(key)) {
                return withdrawTypeEnum.getValue();
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
