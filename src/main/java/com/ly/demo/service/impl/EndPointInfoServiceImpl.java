package com.ly.demo.service.impl;

import com.ly.demo.dao.EndPointInfoMapper;
import com.ly.demo.entity.EndPointInfo;
import com.ly.demo.service.EndPointInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EndPointInfoServiceImpl implements EndPointInfoService {
    @Resource
    EndPointInfoMapper endPointInfoMapper;

    @Override
    public List<EndPointInfo> selectByPage(Integer num){
        return endPointInfoMapper.selectByPage(num);
    }
}
