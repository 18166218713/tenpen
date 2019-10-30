package com.tenpen.base.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseQueryConditionDTO implements Serializable{

    /**
     * 开始位置
     */
    private int offset = 1;

    /**
     * 页面记录数
     */
    private int limit = 15;
}
