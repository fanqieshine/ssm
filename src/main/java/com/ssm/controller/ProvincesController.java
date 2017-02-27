package com.ssm.controller;
import com.ssm.pojo.Provinces;
import com.ssm.service.ProvincesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by huangcr02 on 2017/1/13 013.
 */
@Controller
public class ProvincesController {
    @Resource
    private ProvincesService provincesService;
    @RequestMapping("pro")
    public String show(HttpServletRequest request, Model model){
        Provinces provinces = provincesService.getProvincesById("200");
        model.addAttribute("pro",provinces);
        return "list.jsp";
    }
}