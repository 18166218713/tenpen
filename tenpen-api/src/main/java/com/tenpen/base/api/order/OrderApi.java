package com.tenpen.base.api.order;

import com.tenpen.base.api.bookmarks.BookmarksApi;
import com.tenpen.base.service.order.OrderService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/24.
 */
@Controller
@RequestMapping(value = "/api/order", produces = "application/json")
public class OrderApi {

    private static final Logger logger = LoggerFactory.getLogger(OrderApi.class);

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    @ResponseBody
    public String getOrders(@RequestHeader("Authorization") String authorization,
                               @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                               @RequestParam(value = "userId", required = true) String userId,
                               @RequestParam(value = "userAccount", required = true) String userAccount,
                               @RequestParam(value = "type", required = true) String type,
                               @RequestParam(value = "offset", required = true) int offset,
                               @RequestParam(value = "limit", required = true) int limit) {
        try {
            logger.info("get user orders records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = orderService.getOrders(userId,type,offset,limit);
            return ResponseResult.setSuccess("get user orders is success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("get user orders  error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public String deleteOrder(@RequestHeader("Authorization") String authorization,
                                  @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                  @RequestBody String params) {
        try {
            logger.info("delete order authorization:{},date:{},requestId:{}", authorization, date, requestId);
            orderService.deleteOrder(params);
            return ResponseResult.setSuccess("delete order is success!", null, requestId);
        } catch (Exception e) {
            logger.info("delete order error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }


    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public String confirmOrder(@RequestHeader("Authorization") String authorization,
                              @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                              @RequestBody String params) {
        try {
            logger.info("confirm order authorization:{},date:{},requestId:{}", authorization, date, requestId);
            orderService.confirmOrder(params);
            return ResponseResult.setSuccess("confirm order is success!", null, requestId);
        } catch (Exception e) {
            logger.info("confirm order error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

}
