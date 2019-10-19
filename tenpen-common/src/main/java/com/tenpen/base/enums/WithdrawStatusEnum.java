package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/26.
 */
public enum  WithdrawStatusEnum {
    HANDLING("1","提现中"),
    SUCCESS("2","提现成功"),
    FAIL("3","提现失败");


    private String status;
    private String value;

    WithdrawStatusEnum(String status, String value) {
        this.status = status;
        this.value = value;
    }

    public static String getValueByStatus(String status) {
        for (WithdrawStatusEnum statusEnum : WithdrawStatusEnum.values()) {
            if (statusEnum.getStatus().equalsIgnoreCase(status)) {
                return statusEnum.getValue();
            }
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
