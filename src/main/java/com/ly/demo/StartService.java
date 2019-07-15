package com.ly.demo;

import com.alibaba.fastjson.JSONObject;
import com.ly.demo.controller.DemoController;
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
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(value = 1)
public class StartService implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartService.class);


    private final String KEY = "3fa6f09b";
    private final int ID = 1;
    private final String ENCODING = "utf-8";


    @Resource
    EndPointInfoService endPointInfoService;

    @Resource
    CurrentDataService currentDataService;

    @Resource
    TransferDataService transferDataService;

    @Resource
    ErrorLogService errorLogService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int currentid = 0;
        int onoff = 0;
        CurrentID cid = null;
        String url = "http://47.103.84.246/api/mc";
        int groupSize = 1;
        while (true) {
            cid = currentDataService.selectByPrimaryKey(ID);
            onoff = cid.getOnoff();
            if(0==onoff){
                logger.info("service is stoped.");
                continue;
            }
            currentid = cid.getCurrentid();
            url = cid.getAgent();
            groupSize = cid.getGroupsize();
            ArrayList arrayList = new ArrayList();
            if (currentid > 0) {
                List<EndPointInfo> list = endPointInfoService.selectByPage(groupSize);
                for (EndPointInfo e : list) {
                    JsonData jsonData = new JsonData();
                    if (e.getId() > currentid) {
                        currentid = e.getId();
                    }
                    jsonData.setIp(e.getDeviceIp());
                    jsonData.setUa(e.getDeviceUa());
                    arrayList.add(jsonData);
                }
                CurrentID currentID = new CurrentID();
                currentID.setId(ID);
                currentID.setCurrentid(currentid);
                currentDataService.updateByPrimaryKey(currentID);
                try {
                    String sendContent = DesECBUti.encryptDES(JSONObject.toJSONString(arrayList), KEY);
                    String ret = transferDataService.sendPostDataByJson(url, sendContent, ENCODING);
                    if (HttpStatus.SC_INTERNAL_SERVER_ERROR == Integer.valueOf(ret)) {
                        writeLog(url, currentid,1);
                        ret = transferDataService.sendPostDataByJson(url, sendContent, ENCODING);
                        logger.info("返回结果：" + ret);
                    }
                    writeLog(url, currentid,0);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    writeLog(url, currentid,1);
                }
            }
        }
    }

    private void writeLog(String url, int currentid, int result) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setAgent(url);
        errorLog.setCurrentid(String.valueOf(currentid));
        errorLog.setResult(result);
        errorLogService.writeLog(errorLog);
    }
}
