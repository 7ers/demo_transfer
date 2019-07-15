package com.ly.demo;

import com.alibaba.fastjson.JSONObject;
import com.ly.demo.entity.CurrentID;
import com.ly.demo.entity.EndPointInfo;
import com.ly.demo.service.CurrentDataService;
import com.ly.demo.utils.DesECBUti;
import com.ly.demo.utils.JsonData;
import org.apache.http.HttpStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }

}
