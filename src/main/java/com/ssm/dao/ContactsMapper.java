package com.ssm.dao;

import com.ssm.pojo.Contacts;

import java.util.ArrayList;

public interface ContactsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(Integer id);

    ArrayList<Contacts> selectByPage(Integer start,Integer page_length);

    ArrayList<Contacts> selectAll();

    Integer count();

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);
}