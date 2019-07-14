package com.ly.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.ly.demo.utils.JsonData;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TransferDataServiceImplTest {

    @Test
    public String sendPostDataByJson(String url, String s, String s1) {
        String url1 = "http://localhost:8080/httpService/sendPostDataByJson";
        JsonData jsonData = new JsonData("127.0.0.1","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        String body = sendPostDataByJson(url1, jsonData.toString(), "utf-8");
        System.out.println("响应结果：" + body);
        return body;
    }
}