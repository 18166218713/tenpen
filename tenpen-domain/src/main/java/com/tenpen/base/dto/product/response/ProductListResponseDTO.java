package com.tenpen.base.dto.product.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductListResponseDTO implements Serializable{

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品主题
     */
    private String title;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 主图
     */
    private String mainImageUrl;

    /**
     * 发布时间
     */
    private Date createTime;
}
