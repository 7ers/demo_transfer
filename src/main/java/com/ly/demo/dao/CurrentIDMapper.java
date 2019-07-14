package com.ly.demo.dao;

import com.ly.demo.entity.CurrentID;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CurrentIDMapper {

    CurrentID selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(CurrentID record);
}