package com.tenpen.base.util;

/**
 * 统一响应结果
 */
public class ResponseResult {

    public static String setSuccess(String message, Object obj, String requestId) {
        BaseResult result = new BaseResult();
        result.setCode("200");
        result.setMessage(message);
        result.setRequestId(requestId);
        result.setType("success");
        result.setData(obj);
        return FastJsonUtils.getBeanToJson(result);
    }

    public static String setError(String message, String requestId) {
        BaseResult result = new BaseResult();
        result.setCode("500");
        result.setMessage(message);
        result.setRequestId(requestId);
        result.setType("error");
        return FastJsonUtils.getBeanToJson(result);
    }
}
