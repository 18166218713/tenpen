package com.tenpen.base.api.user;

import com.tenpen.base.annotations.AuthRequired;
import com.tenpen.base.service.user.UserService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用戶API包含
 * Created by x00376013 on 2019/9/24.
 */
@Controller
@RequestMapping(value = "/api/user", produces = "application/json")
public class UserApi {

    private static final Logger logger = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.POST)
    @ResponseBody
    public String getVerifyCode(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestBody String params) {
        try {
            logger.info("getVerifyCode authorization:{},date:{},requestId:{}", authorization, date, requestId);
            Map<String,Object> resultMap = userService.getVerifyCode(params);
            return ResponseResult.setSuccess("get code is success!", resultMap, requestId);
        } catch (Exception e) {
            logger.info("getVerifyCode error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestHeader("Authorization") String authorization,
                        @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                        @RequestHeader("x-request-ip") String requestIp, @RequestHeader("x-device-os") String deviceOs,
                        @RequestHeader("x-device-name") String deviceName,
                        @RequestBody String params) {
        try {
            logger.info("login authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.login(params,requestIp,deviceOs,deviceName);
            return ResponseResult.setSuccess("user login success!", null, requestId);
        } catch (Exception e) {
            logger.info("user login error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    @ResponseBody
    public String modifyPassword(@RequestHeader("Authorization") String authorization,
                                 @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                 @RequestBody String params) {
        try {
            logger.info("modifyPassword authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.modifyPassword(params);
            return ResponseResult.setSuccess("modify password success!",null,requestId);
        } catch (Exception e) {
            logger.info("modify password error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/modifyPhoneNo", method = RequestMethod.POST)
    @ResponseBody
    public String modifyPhoneNo(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestBody String params) {
        try {
            logger.info("modifyPhoneNo authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.modifyPhoneNo(params);
            return ResponseResult.setSuccess("modify phone number success!",null,requestId);
        } catch (Exception e) {
            logger.info("modify phoneNo error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/addRecAddress", method = RequestMethod.POST)
    @ResponseBody
    public String addRecAddress(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestBody String params) {
        try {
            logger.info("addRecAddress authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.addRecAddress(params);
            return ResponseResult.setSuccess("add rec address success!", null, requestId);
        } catch (Exception e) {
            logger.info("add rec address error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/modifyRecAdress", method = RequestMethod.POST)
    @ResponseBody
    public String modifyRecAdress(@RequestHeader("Authorization") String authorization,
                                  @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                  @RequestBody String params) {
        try {
            logger.info("modifyRecAdress authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.modifyRecAdress(params);
            return ResponseResult.setSuccess("modify rec address success!", null, requestId);
        } catch (Exception e) {
            logger.info("modify rec address error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/delRecAddress", method = RequestMethod.POST)
    @ResponseBody
    public String delRecAddress(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestBody String params) {
        try {
            logger.info("delRecAddress authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.delRecAddress(params);
            return ResponseResult.setSuccess("delete rec address success!", null, requestId);
        } catch (Exception e) {
            logger.info("delete rec address error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/getRecAddress", method = RequestMethod.POST)
    @ResponseBody
    public String getRecAddress(@RequestHeader("Authorization") String authorization,
                                @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                @RequestBody String params) {
        try {
            logger.info("getRecAddress authorization:{},date:{},requestId:{}", authorization, date, requestId);
            List resultList = userService.getRecAddress(params);
            return ResponseResult.setSuccess("query address success!", resultList, requestId);
        } catch (Exception e) {
            logger.info("get rec address error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/setDefualtAdress", method = RequestMethod.POST)
    @ResponseBody
    public String setDefualtAdress(@RequestHeader("Authorization") String authorization,
                                   @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                   @RequestBody String params) {
        try {
            logger.info("setDefualtAdress authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.setDefualtAdress(params);
            return ResponseResult.setSuccess("set defualt address success!", null, requestId);
        } catch (Exception e) {
            logger.info("set defualt address error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }


    @RequestMapping(value = "/setUserName", method = RequestMethod.POST)
    @ResponseBody
    public String setUserName(@RequestHeader("Authorization") String authorization,
                                   @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                                   @RequestBody String params) {
        try {
            logger.info("setUserName authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.setUserName(params);
            return ResponseResult.setSuccess("set user name success!", null, requestId);
        } catch (Exception e) {
            logger.info("set user name error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }

    @RequestMapping(value = "/setUserPassword", method = RequestMethod.POST)
    @ResponseBody
    public String setUserPassword(@RequestHeader("Authorization") String authorization,
                              @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                              @RequestBody String params) {
        try {
            logger.info("setUserPassword authorization:{},date:{},requestId:{}", authorization, date, requestId);
            userService.setUserPassword(params);
            return ResponseResult.setSuccess("set user password success!", null, requestId);
        } catch (Exception e) {
            logger.info("set user password error:{}", e.getMessage());
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }
}
