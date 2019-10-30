package com.tenpen.base.api.incomes;

import com.tenpen.base.api.member.MemberApi;
import com.tenpen.base.service.incomes.IncomeService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 收益API
 * Created by x00376013 on 2019/9/26.
 */
@Controller
@RequestMapping(value = "/api/incomes", produces = "application/json")
public class IncomesApi {

    private static final Logger logger = LoggerFactory.getLogger(IncomesApi.class);

    @Autowired
    IncomeService incomeService;


    @RequestMapping(value = "/getIncomes", method = RequestMethod.GET)
    @ResponseBody
    public String getIncomes(@RequestHeader("Authorization") String authorization,
                                   @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                   @RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "incomesType", required = true) String incomesType,
                                   @RequestParam(value = "offset", required = true) int offset,
                                   @RequestParam(value = "limit", required = true) int limit) {
        try {
            logger.info("get user incomes records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = incomeService.getIncomes(userId,incomesType,offset,limit);
            return ResponseResult.setSuccess("get incomes is success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("gget user incomes  error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/getMyIncomes", method = RequestMethod.GET)
    @ResponseBody
    public String getMyIncomes(@RequestHeader("Authorization") String authorization,
                             @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                             @RequestParam(value = "userId", required = true) String userId) {
        try {
            logger.info("get user self incomes records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            Map<String,Object> resultMap = incomeService.getMyIncomes(userId);
            return ResponseResult.setSuccess("get incomes is success!", resultMap, requestId);
        } catch (Exception e) {
            logger.info("gget user self incomes  error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }


    @RequestMapping(value = "/getWithdraws", method = RequestMethod.GET)
    @ResponseBody
    public String getWithdraws(@RequestHeader("Authorization") String authorization,
                             @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                             @RequestParam(value = "userId", required = true) String userId,
                             @RequestParam(value = "offset", required = true) int offset,
                             @RequestParam(value = "limit", required = true) int limit) {
        try {
            logger.info("get user incomes withdraws records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = incomeService.getWithdraws(userId,offset,limit);
            return ResponseResult.setSuccess("get withdraws is success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("gget user incomes withdraws error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }


}
