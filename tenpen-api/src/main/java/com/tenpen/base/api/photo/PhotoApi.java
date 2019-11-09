package com.tenpen.base.api.photo;

import com.tenpen.base.api.order.OrderApi;
import com.tenpen.base.service.photos.PhotoService;
import com.tenpen.base.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by x00376013 on 2019/9/24.
 */
@Controller
@RequestMapping(value = "/api/photos", produces = "application/json")
public class PhotoApi {

    private static final Logger logger = LoggerFactory.getLogger(PhotoApi.class);

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "/createPhoto", method = RequestMethod.POST)
    @ResponseBody
    public String createPhoto(@RequestHeader("Authorization") String authorization,
                              @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                              @RequestBody String params) {
        try {
            logger.info("create photo authorization:{},date:{},requestId:{}", authorization, date, requestId);
            photoService.createPhoto(params);
            return ResponseResult.setSuccess("create order is success!", null, requestId);
        } catch (Exception e) {
            logger.info("create photo error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }


    @RequestMapping(value = "/deletePhoto", method = RequestMethod.POST)
    @ResponseBody
    public String deletePhoto(@RequestHeader("Authorization") String authorization,
                              @RequestHeader("Date") String date, @RequestHeader("RequestId") String requestId,
                              @RequestBody String params) {
        try {
            logger.info("delete photo authorization:{},date:{},requestId:{}", authorization, date, requestId);
            photoService.deletePhoto(params);
            return ResponseResult.setSuccess("delete photo is success!", null, requestId);
        } catch (Exception e) {
            logger.info("delete photo error,params:{}", params);
            return ResponseResult.setError(e.getMessage(), requestId);
        }
    }




}
