package com.tenpen.base.service.product.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ProductDetailDTO implements Serializable{

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal price;

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
    private Integer useTime;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 图片list
     */
    private List<String> imageList;
}
