package com.project.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;

/**
 * @Author: jiazhuang
 * @Description: 发送短信
 * @Date: 10:19 2018/5/7
 */
public class SmsSenderUtil {
    //初始化ascClient需要的几个参数
    //短信API产品名称（短信产品名固定，无需修改）
    private final static String PRODUCT = "Dysmsapi";
    //短信API产品域名（接口地址固定，无需修改）
    private final static String DOMAIN = "dysmsapi.aliyuncs.com";
    //阿里云平台生成，无需修改
    private final static String ACCESS_KEY_ID = "LTAIjl4GlMltMHkh";
    //阿里云平台生成，无需修改
    private final static String ACCESS_KEY_SECRET = "zdutUqhAVKofqoKhk8zf8xE2tmWhzD";
    //模板code
    private final static String TEMPLATE_CODE = "SMS_134255097";
    //签名
    private final static String SIGNATURE = "九尾狐";
    //response code
    private final static String RESPONSE_OK = "OK";

    private static IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID,
            ACCESS_KEY_SECRET);

    private static IAcsClient acsClient = new DefaultAcsClient(profile);

    public static boolean sendVerifyCode(String mobile) throws Exception {
        return sendVerifyCode(mobile, null);
    }

    /**
     * 发送验证码短信
     *
     * @param mobile
     * @throws Exception
     */
    public static boolean sendVerifyCode(String mobile,String vcode) throws Exception {
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        /* 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,
           验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000” */
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGNATURE);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(TEMPLATE_CODE);
        //随机生成验证码
        String code = vcode == null? generateCode(4):vcode;
        /* 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要
           表示成\\r\\n,否则会导致JSON在服务端解析失败 */
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && RESPONSE_OK.equals(sendSmsResponse.getCode())) {
            //TODO:请求成功后续操作
            System.out.println("RequestId:" + sendSmsResponse.getRequestId());
            System.out.println("Code:" + sendSmsResponse.getCode());
            System.out.println("Message:" + sendSmsResponse.getMessage());
            System.out.println("BizId:" + sendSmsResponse.getBizId());
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据长度生成随机数
     *
     * @param codeLength
     * @return
     */
    public static String generateCode(int codeLength) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


}
