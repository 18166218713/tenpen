package com.tenpen.base.enums;

public enum RecommendTypeEnum {
    PRODUCT("1","自拍推荐"),
    PHOTO("2","商品推荐");

    private String key;
    private String value;

    RecommendTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(String key) {
        for (RecommendTypeEnum recommendTypeEnum : RecommendTypeEnum.values()) {
            if (recommendTypeEnum.getKey().equalsIgnoreCase(key)) {
                return recommendTypeEnum.getValue();
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
