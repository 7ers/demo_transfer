package com.ly.demo.service.impl;

import com.ly.demo.dao.CurrentIDMapper;
import com.ly.demo.entity.CurrentID;
import com.ly.demo.service.CurrentDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CurrentDataServiceImpl implements CurrentDataService {

    @Resource
    private CurrentIDMapper currentIDMapper;

    @Override
    public int updateByPrimaryKey(CurrentID currentID) {
        return currentIDMapper.updateByPrimaryKey(currentID);
    }

    @Override
    public CurrentID selectByPrimaryKey(Integer id) {
        return currentIDMapper.selectByPrimaryKey(id);
    }
}
