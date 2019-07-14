package com.ly.demo.service;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface TransferDataService {
    public String sendPostDataByJson(String url, String json, String encoding) throws ClientProtocolException,IOException;
}
