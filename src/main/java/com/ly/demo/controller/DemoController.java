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

    private final String KEY = "3fa6f09b";
    private final int GROUP_MAX = 1;

    @Resource
    EndPointInfoService endPointInfoService;

    @Resource
    CurrentDataService currentDataService;

    @Resource
    TransferDataService transferDataService;

    @Resource
    ErrorLogService errorLogService;

    @GetMapping("/start")
    public String shipData(String url){
        String result = "success";
        int currentid = 0;
//        while(true){
            currentid = currentDataService.selectByPrimaryKey(1).getCurrentid();
            ArrayList arrayList = new ArrayList();
            if(currentid!=0){
                List<EndPointInfo> list = endPointInfoService.selectByPage(GROUP_MAX);
                for (EndPointInfo e: list) {
                    JsonData jsonData = new JsonData();
                    if(e.getId()>currentid){
                        currentid = e.getId();
                    }
                    jsonData.setIp(e.getDeviceIp());
                    jsonData.setUa(e.getDeviceUa());
                    arrayList.add(jsonData);
                }
                CurrentID currentID = new CurrentID();
                currentID.setId(1);
                currentID.setCurrentid(currentid);
                currentDataService.updateByPrimaryKey(currentID);
                try {
                    String sendContent = DesECBUti.encryptDES(JSONObject.toJSONString(arrayList),KEY);
//                    String ret = transferDataService.sendPostDataByJson(url, sendContent,"utf-8");
                    writeLog(url,currentid);
//                    if(HttpStatus.SC_INTERNAL_SERVER_ERROR == Integer.valueOf(ret)){
//                        writeLog(url,currentid);
//                        ret = transferDataService.sendPostDataByJson(url, sendContent,"utf-8");
//                        logger.info("返回结果："+ret);
//                        result = ret;
//                    }
                } catch (Exception e) {
                }

            }
//            if(currentid==-1){
//                break;
//            }
//        }
        return result;
    }

    private void writeLog(String url, int currentid){
        ErrorLog errorLog =  new ErrorLog();
        errorLog.setAgent(url);
        errorLog.setCurrentid(String.valueOf(currentid));
        errorLogService.writeLog(errorLog);
    }
}
