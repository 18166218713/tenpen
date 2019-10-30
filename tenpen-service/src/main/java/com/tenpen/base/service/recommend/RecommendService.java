package com.tenpen.base.service.recommend;

import java.util.Map;

/**
 * Created by x00376013 on 2019/9/24.
 */
public interface RecommendService {

    /**
     * 获取推荐位置
     *
     * @param type 推荐类型 1 自拍推荐位 2 商品推荐位
     * @return 获取推荐数据
     */
    Map<String, Object> getRecommends(String type);
}
