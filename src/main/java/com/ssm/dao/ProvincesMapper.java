package com.ssm.dao;

import com.ssm.pojo.Provinces;

public interface ProvincesMapper {
    int deleteByPrimaryKey(String code);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    Provinces selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);
}