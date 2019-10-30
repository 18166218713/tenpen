package com.tenpen.base.service.bookmarks;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/26.
 */
public interface BookmarkService {

    /**
     * 分页查询收藏数据
     *
     * @param userId 用户ID
     * @param type   收藏类型 1商品收藏 2 自拍收藏
     * @param offset 开始位置
     * @param limit  总数据
     * @return
     */
    List getBookmarks(String userId, String type, int offset, int limit);

    /**
     * 添加收藏
     *
     * @param params 入参
     */
    void addBookmarks(String params);

    /**
     * 取消收藏
     *
     * @param params 入参
     */
    void cancelBookmarks(String params);
}
