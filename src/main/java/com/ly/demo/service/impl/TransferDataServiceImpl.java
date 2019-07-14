package com.ly.demo.service.impl;

import com.ly.demo.service.TransferDataService;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class TransferDataServiceImpl implements TransferDataService {

    /**
     * post请求传输json数据
     *
     * @param url url地址
     * @param json json数据
     * @param encoding 编码方式
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    @Override
    public String sendPostDataByJson(String url, String json, String encoding) throws ClientProtocolException, IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 设置参数到请求对象中
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpPost);
        }catch (ClientProtocolException cpe){
            cpe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();

        return String.valueOf(statusCode);
    }

}
