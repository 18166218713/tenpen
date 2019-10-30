package com.tenpen.base.dto.product.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateProductDTO implements Serializable{

    /**
     * 主题
     */
    private String title;

    /**
     * 描述
     */
    private String remark;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 是否包邮
     */
    private Integer isIncludePost;

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
     * 主图
     */
    private String mainImageUrl;

    /**
     * 图片list
     */
    private List<String> imageList;

    /**
     * 创建者ID
     */
    private String createBy;

    /**
     * 创建者名称
     */
    private String creator;
}
