package com.ssm.service;

import com.ssm.pojo.Contacts;

import java.util.ArrayList;

/**
 * Created by huangcr02 on 2017/1/16 016.
 */
public interface ContactsService {
    public Contacts getContactsById(Integer id);
    public ArrayList<Contacts> getAllContacts();
    public Integer getCounts();
    public ArrayList<Contacts> getContactsByPage(Integer start,Integer page_length);
}
