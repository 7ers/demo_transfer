package com.ly.demo.service;

import com.ly.demo.entity.CurrentID;
import org.springframework.stereotype.Service;

public interface CurrentDataService {
    int updateByPrimaryKey(CurrentID currentID);
    CurrentID selectByPrimaryKey(Integer id);
}
