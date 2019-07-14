package com.ly.demo.service;

import com.ly.demo.entity.EndPointInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EndPointInfoService {
    List<EndPointInfo> selectByPage(Integer num);
}
