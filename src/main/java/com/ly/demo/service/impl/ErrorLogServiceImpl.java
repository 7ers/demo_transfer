package com.ly.demo.service.impl;

import com.ly.demo.dao.ErrorLogMapper;
import com.ly.demo.entity.ErrorLog;
import com.ly.demo.service.ErrorLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {

    @Resource
    ErrorLogMapper errorLogMapper;

    @Override
    public void writeLog(ErrorLog errorLog) {
        errorLogMapper.insert(errorLog);
    }
}
