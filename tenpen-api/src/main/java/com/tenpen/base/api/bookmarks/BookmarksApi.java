package com.tenpen.base.api.bookmarks;

import com.tenpen.base.service.bookmarks.BookmarkService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Controller
@RequestMapping(value = "/api/bookmarks", produces = "application/json")
public class BookmarksApi {

    private static final Logger logger = LoggerFactory.getLogger(BookmarksApi.class);

    @Autowired
    BookmarkService bookmarkService;

    @RequestMapping(value = "/getBookmarks", method = RequestMethod.GET)
    @ResponseBody
    public String getBookmarks(@RequestHeader("Authorization") String authorization,
                             @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                             @RequestParam(value = "userId", required = true) String userId,
                             @RequestParam(value = "userAccount", required = true) String userAccount,
                             @RequestParam(value = "type", required = true) String type,
                             @RequestParam(value = "offset", required = true) int offset,
                             @RequestParam(value = "limit", required = true) int limit) {
        try {
            logger.info("get user bookmarks records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = bookmarkService.getBookmarks(userId,type,offset,limit);
            return ResponseResult.setSuccess("get bookmarks is success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("gget user bookmarks  error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/addBookmarks", method = RequestMethod.POST)
    @ResponseBody
    public String addBookmarks(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestBody String params) {
        try {
            logger.info("getVerifyCode authorization:{},date:{},requestId:{}", authorization, date, requestId);
            bookmarkService.addBookmarks(params);
            return ResponseResult.setSuccess("add bookmark is success!", null, requestId);
        } catch (Exception e) {
            logger.info("add bookmark error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/cancelBookmarks", method = RequestMethod.POST)
    @ResponseBody
    public String cancelBookmarks(@RequestHeader("Authorization") String authorization,
                               @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                               @RequestBody String params) {
        try {
            logger.info("cancelBookmarks authorization:{},date:{},requestId:{}", authorization, date, requestId);
            bookmarkService.cancelBookmarks(params);
            return ResponseResult.setSuccess("cancel bookmarks is success!", null, requestId);
        } catch (Exception e) {
            logger.info("cancel bookmarks error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }
}
