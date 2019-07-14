package com.ly.demo.dao;

import com.ly.demo.entity.EndPointInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EndPointInfoMapper {
    List<EndPointInfo> selectByPage(Integer num);
}