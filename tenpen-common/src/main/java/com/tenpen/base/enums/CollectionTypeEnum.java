package com.tenpen.base.enums;

/**
 * Created by x00376013 on 2019/9/26.
 */
public enum CollectionTypeEnum {

    PRODUCT("1","商品收藏"),
    PHOTO("2","自拍收藏");

    private String key;
    private String value;

    CollectionTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(String key) {
        for (CollectionTypeEnum collectionTypeEnum : CollectionTypeEnum.values()) {
            if (collectionTypeEnum.getKey().equalsIgnoreCase(key)) {
                return collectionTypeEnum.getValue();
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
