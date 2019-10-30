package com.tenpen.base.api.member;

import com.tenpen.base.api.user.UserApi;
import com.tenpen.base.service.member.MemberService;
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
@RequestMapping(value = "/api/member", produces = "application/json")
public class MemberApi {

    private static final Logger logger = LoggerFactory.getLogger(MemberApi.class);
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/getMemberRecords", method = RequestMethod.GET)
    @ResponseBody
    public String getMemberRecords(@RequestHeader("Authorization") String authorization,
                                   @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                   @RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "offset", required = true) int offset,
                                   @RequestParam(value = "limit", required = true) int limit) {
        try {
            logger.info("get member records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = memberService.getMemberRecords(userId,offset,limit);
            return ResponseResult.setSuccess("get code is success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("get member records error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/getMemberInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getMemberInfo(@RequestHeader("Authorization") String authorization,
                                   @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                   @RequestParam(value = "userId", required = true) String userId) {
        try {
            logger.info("get member records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            Map<String,Object> memeberMap = memberService.getMemberInfo(userId);
            return ResponseResult.setSuccess("get code is success!", memeberMap, requestId);
        } catch (Exception e) {
            logger.info("get member records error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/isMember", method = RequestMethod.POST)
    @ResponseBody
    public String isMember(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestParam(value = "userId", required = true) String userId) {
        try {
            logger.info("is member authorization:{},date:{},requestId:{}", authorization, date, requestId);
            Map<String,Object> memeberMap = memberService.isMember(userId);
            return ResponseResult.setSuccess("get code is success!", memeberMap, requestId);
        } catch (Exception e) {
            logger.info("is member error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }
}
