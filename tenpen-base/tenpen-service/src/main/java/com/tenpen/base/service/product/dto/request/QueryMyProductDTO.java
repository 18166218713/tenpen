package com.tenpen.base.service.product.dto.request;

import com.tenpen.base.util.BaseQueryConditionDTO;
import lombok.Data;

@Data
public class QueryMyProductDTO extends BaseQueryConditionDTO {

    /**
     * 用户id
     */
    private String userId;
}
