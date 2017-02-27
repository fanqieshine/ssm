package com.ssm.service.impl;

import com.ssm.dao.ContactsMapper;
import com.ssm.pojo.Contacts;
import com.ssm.service.ContactsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by huangcr02 on 2017/1/16 016.
 */
@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {
    @Resource
    private ContactsMapper contactsMapper;

    @Override
    public Contacts getContactsById(Integer id) {
        return contactsMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArrayList<Contacts> getAllContacts() {
        return contactsMapper.selectAll();
    }

    @Override
    public Integer getCounts() {
        return contactsMapper.count();
    }

    @Override
    public ArrayList<Contacts> getContactsByPage(Integer start, Integer page_length) {
        return contactsMapper.selectByPage(start, page_length);
    }
}
