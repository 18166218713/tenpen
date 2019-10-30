package com.tenpen.base.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.util.FastJsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/25.
 */
@Component
public class SmsClient {

    private static final Logger logger = LoggerFactory.getLogger(SmsClient.class);

    private final String signName = "原味";
    private final String templateCode = "SMS_174811917";
    private final String accessKeyId = "LTAI4FvAwS3croEspZcwSzjX";
    private final String accessSecret = "Qzaww9yCXWrwZdeUfiD67jtxObLpTN";

    public void sendSms(String phoneNumber, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        request.putQueryParameter("TemplateParam", FastJsonUtils.getBeanToJson(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info("ali smd response data info:{}", response.getData());
            String resultCode = (String) FastJsonUtils.getValueByKey(response.getData(), "code");
            if (!StringUtils.equalsIgnoreCase(resultCode, "OK")) {
                throw new ServiceException("ali sms response is not ok!");
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
