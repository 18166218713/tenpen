package com.tenpen.base.api.recommend;

import com.tenpen.base.api.bookmarks.BookmarksApi;
import com.tenpen.base.service.bookmarks.BookmarkService;
import com.tenpen.base.service.recommend.RecommendService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/24.
 */
@Controller
@RequestMapping(value = "/api/recommends", produces = "application/json")
public class RecommandApi {

    private static final Logger logger = LoggerFactory.getLogger(RecommandApi.class);

    @Autowired
    RecommendService recommendService;

    @RequestMapping(value = "/getRecommends", method = RequestMethod.GET)
    @ResponseBody
    public String getRecommends(@RequestHeader("Authorization") String authorization,
                               @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                               @RequestParam(value = "type", required = true) String type) {

        try{
            logger.info("get recommeds authorization:{},date:{},requestId:{}", authorization, date, requestId);
            Map<String,Object> resultMap = recommendService.getRecommends(type);
            return ResponseResult.setSuccess("get recommeds is success!", resultMap, requestId);
        }catch (Exception e){
            logger.info("get recommeds  error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

}
