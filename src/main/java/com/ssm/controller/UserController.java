package com.ssm.controller;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangcr02 on 2017/1/23 023.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String id = request.getParameter("name");
        String pwd = request.getParameter("password");
        if (id == null || id.trim().equals("") || pwd == null) return "login.jsp";
        User user = userService.getUserById(id);
        if (user == null || !user.getPwd().equals(pwd)) {
            model.addAttribute("error", "用户名或密码错误！");
            return "login.jsp";
        } else {
            return "../index.jsp";
        }
    }
}
