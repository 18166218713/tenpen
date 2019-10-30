package com.tenpen.base.service.product.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateProductDTO implements Serializable{

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 价格
     */
    private String price;

    /**
     * 主题
     */
    private String title;

    /**
     * 职业
     */
    private String career;

    /**
     * 颜色
     */
    private String color;

    /**
     * 使用时间
     */
    private String useTime;

    /**
     * 描述
     */
    private String remark;

    /**
     * 图片list
     */
    private List<String> imageList;
}
