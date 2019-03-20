package com.lhy.mybatis1.entity;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@Slf4j
public class UserTest {

    @Test
    public void testLombok() throws JSONException {
        String json = "{\"apiKey\":\"PDA\",\"timestamp\":\"2018-07-26 16:50:32\",\"digest\":\"/augW3DLjvP8mGFC7oKYQg==\",\"data\":[{\"wbId\":\"123456\",\"creater\":\"6543210\",\"createName\":\"青浦中心\",\"barcodeList\":[{\"barcode\":\"TEST201807261650-11\",\"printedDt\":\"2018-07-26 16:50:32\"},{\"barcode\":\"TEST201807261650-12\",\"printedDt\":\"2018-07-26 16:50:32\"}]}]}";
//        String jsonAPP = "{\n" +
//                "\"apiKey\": \"PDA\",\n" +
//                "\"data\": [\n" +
//                "{\n" +
//                "\"barcodeList\": [\n" +
//                "{\n" +
//                "\"barcode\": \"843000234001\",\n" +
//                "\"printedDt\": \"2018-07-26 10:58:29\"\n" +
//                "}\n" +
//                "],\n" +
//                "\"createName\": \"张发康\",\n" +
//                "\"creater\": \"6412\",\n" +
//                "\"wbId\": \"84300023\"\n" +
//                "}\n" +
//                "],\n" +
//                "\"digest\": \"HAK+Yv93XGyHL2Q1tPgB9A==\",\n" +
//                " \"timestamp\": \"2018-07-26 10:58:36\"\n" +
//                "}";
        String jsonAPP = "{\"apiKey\":\"PDA\",\"data\":[{\"barcodeList\":[{\"barcode\":\"350050644001\",\"printedDt\":\"2018-07-26 17:34:30\"}],\"createName\":\"张发康\",\"creater\":\"6412\",\"wbId\":\"35005064\"}],\"timestamp\":\"2018-07-26 17:34:34\"}";
        JSONObject jsonObject = new JSONObject(jsonAPP);
        JSONArray dataAPP = jsonObject.getJSONArray("data");

        JSONObject jsonObjectServer = new JSONObject(json);
        JSONArray dataServer = jsonObjectServer.getJSONArray("data");
        log.info(dataAPP.toString());
        log.info(dataServer.toString());
    }
}