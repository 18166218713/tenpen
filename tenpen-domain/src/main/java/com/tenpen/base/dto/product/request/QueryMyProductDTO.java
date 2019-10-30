package com.tenpen.base.dto.product.request;

import com.tenpen.base.util.BaseQueryConditionDTO;
import lombok.Data;

@Data
public class QueryMyProductDTO extends BaseQueryConditionDTO {

    /**
     * 用户id
     */
    private String userId;
}
