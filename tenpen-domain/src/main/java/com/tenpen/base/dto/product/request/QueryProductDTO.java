package com.tenpen.base.dto.product.request;

import com.tenpen.base.util.BaseQueryConditionDTO;
import lombok.Data;

@Data
public class QueryProductDTO extends BaseQueryConditionDTO {

    /**
     * 关键字
     */
    private String keyword;
}
