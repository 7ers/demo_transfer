package com.ly.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ly.demo.entity.CurrentID;
import com.ly.demo.entity.EndPointInfo;
import com.ly.demo.entity.ErrorLog;
import com.ly.demo.service.CurrentDataService;
import com.ly.demo.service.EndPointInfoService;
import com.ly.demo.service.ErrorLogService;
import com.ly.demo.service.TransferDataService;
import com.ly.demo.utils.DesECBUti;
import com.ly.demo.utils.JsonData;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    CurrentDataService currentDataService;

    /**
     * 实时开关
     * @param onoff 0-关，1-开
     * @return
     */
    @GetMapping("/onoff")
    public String doOnoff(String onoff){
        String result = "The service is running...";
        CurrentID currentID = new CurrentID();
        currentID.setId(1);
        currentID.setOnoff(Integer.valueOf(onoff));
        int i = currentDataService.updateOnoffByPrimaryKey(currentID);
        if("0".equals(onoff)){
            result = "The service is stoped.";
        }
        return result;
    }
}
