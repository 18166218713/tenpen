package com.tenpen.base.dto.product.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class MyProductDetailDTO implements Serializable{

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品主题
     */
    private String title;

    /**
     * 描述
     */
    private String remark;

    /**
     * 商品价格
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
    private Integer useTime;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 状态 1 草稿 2 待审核 3 审核通过 4 已发布 -1 锁定 5已支付 6已发货 7已完成 0下架
     */
    private Integer status;

    /**
     * 图片list
     */
    private List<String> imageList;
}
