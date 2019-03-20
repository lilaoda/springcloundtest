package com.lhy.mybatis1.service;

import com.lhy.mybatis1.im.CheckSumBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;

@Slf4j
public class UserServiceImplTest {

    @Test
    public void getImToken() {
//        String url = "https://api.netease.im/nimserver/user/create.action";
        String url = "https://api.netease.im/nimserver/user/refreshToken.action";
        String appKey = "f821e57ba587e5f5518f89a1634cae75";
        String appSecret = "d303f5d5e300";
        String nonce =  getRandomString(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        //53   5b4f25a09de1ba0cb6c234e8b2c934ab
        // 设置请求的参数
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("accid", "13922239152");
        params.add("name", "13922239152");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        log.info(response.getBody());
    }

    public static String getRandomString(int length){
        //产生随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //循环length次
        for(int i=0; i<length; i++){
            //产生0-2个随机数，既与a-z，A-Z，0-9三种可能
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                //如果number产生的是数字0；
                case 0:
                    //产生A-Z的ASCII码
                    result=Math.round(Math.random()*25+65);
                    //将ASCII码转换成字符
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    //产生a-z的ASCII码
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    //产生0-9的数字
                    sb.append(String.valueOf
                            (new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}