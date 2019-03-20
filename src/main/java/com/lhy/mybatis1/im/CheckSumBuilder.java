package com.lhy.mybatis1.im;

import java.security.MessageDigest;

public class CheckSumBuilder {

    // 计算并获取CheckSum
    public static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }

    // 计算并获取md5值
    public static String getMD5(String requestBody) {
        return encode("md5", requestBody);
    }

    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest
                    = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };


//    private void test(){
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        String url = "https://api.netease.im/nimserver/user/create.action";
//        HttpPost httpPost = new HttpPost(url);
//
//        String appKey = "94kid09c9ig9k1loimjg012345123456";
//        String appSecret = "123456789012";
//        String nonce =  "12345";
//        String curTime = String.valueOf((new Date()).getTime() / 1000L);
//        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
//
//        // 设置请求的header
//        httpPost.addHeader("AppKey", appKey);
//        httpPost.addHeader("Nonce", nonce);
//        httpPost.addHeader("CurTime", curTime);
//        httpPost.addHeader("CheckSum", checkSum);
//        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        // 设置请求的参数
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("accid", "helloworld"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
//
//        // 执行请求
//        HttpResponse response = httpClient.execute(httpPost);
//
//        // 打印执行结果
//        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
//    }
}
