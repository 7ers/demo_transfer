package com.ly.demo.dao;

import com.ly.demo.entity.ErrorLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ErrorLogMapper {
    int insert(ErrorLog record);
}