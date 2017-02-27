package com.ssm.controller;
import com.ssm.pojo.Contacts;
import com.ssm.service.ContactsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
/**
 * Created by huangcr02 on 2017/1/16 016.
 */
@Controller
public class ContactsController {
    private static Integer PAGE_LENGTH = 8;
    @Resource
    private ContactsService contactsService;
    @RequestMapping("contacts")
    public String showContacts(HttpServletRequest request, Model model) {
        Integer countsOfContacts = contactsService.getCounts();
        Integer pages = countsOfContacts / PAGE_LENGTH + (countsOfContacts % PAGE_LENGTH == 0 ? 0 : 1);
        String page = request.getParameter("page");
        if (null == page) page = "1";
        ArrayList<Contacts> selectContact = contactsService.getContactsByPage(PAGE_LENGTH * (Integer.parseInt(page) - 1), PAGE_LENGTH);
        model.addAttribute("counts", countsOfContacts);//总数
        model.addAttribute("page",page);//当前页
        model.addAttribute("pages",pages);//总页数
        model.addAttribute("contactsOfPage", selectContact);//查询当前页结果
        model.addAttribute("pagelength",PAGE_LENGTH);//单页条数
        return "book.jsp";
    }
}
