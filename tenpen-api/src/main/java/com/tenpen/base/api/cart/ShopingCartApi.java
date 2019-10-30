package com.tenpen.base.api.cart;

import com.tenpen.base.api.bookmarks.BookmarksApi;
import com.tenpen.base.service.cart.CartService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/27.
 */
@Controller
@RequestMapping(value = "/api/cart", produces = "application/json")
public class ShopingCartApi {

    private static final Logger logger = LoggerFactory.getLogger(ShopingCartApi.class);

    @Autowired
    CartService cartService;


    @RequestMapping(value = "/getShoppingCarts", method = RequestMethod.GET)
    @ResponseBody
    public String getShoppingCarts(@RequestHeader("Authorization") String authorization,
                               @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                               @RequestParam(value = "userId", required = true) String userId,
                               @RequestParam(value = "userAccount", required = true) String userAccount,
                               @RequestParam(value = "offset", required = true) int offset,
                               @RequestParam(value = "limit", required = true) int limit) {
        try {
            logger.info("get shopping carts records authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = cartService.getShoppingCarts(userId,offset,limit);
            return ResponseResult.setSuccess("get shopping carts is success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("get shopping carts error,params:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/addShoppingCart", method = RequestMethod.POST)
    @ResponseBody
    public String addBookmarks(@RequestHeader("Authorization") String authorization,
                               @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                               @RequestBody String params) {
        try {
            logger.info("add shopping cart authorization:{},date:{},requestId:{}", authorization, date, requestId);
            cartService.addShoppingCart(params);
            return ResponseResult.setSuccess("add shopping cart is success!", null, requestId);
        } catch (Exception e) {
            logger.info("add shopping cart error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/deleteProducts", method = RequestMethod.POST)
    @ResponseBody
    public String deleteProducts(@RequestHeader("Authorization") String authorization,
                               @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                               @RequestBody String params) {
        try {
            logger.info("delete product cart authorization:{},date:{},requestId:{}", authorization, date, requestId);
            cartService.deleteProducts(params);
            return ResponseResult.setSuccess("delete product cart is success!", null, requestId);
        } catch (Exception e) {
            logger.info("delete product cart error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }
}
