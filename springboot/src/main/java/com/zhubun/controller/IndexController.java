package com.zhubun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhubun.model.UserDO;
import com.zhubun.mapper.UserMapper;
import com.zhubun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    UserService userService;


    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                UserDO userDO = userService.getOne(new QueryWrapper<UserDO>().eq("token",cookie.getValue()));
                if(userDO!=null){
                    request.getSession().setAttribute("user",userDO);
                    System.out.println(cookie.getValue());
                    System.out.println(userDO);
                }
                break;
            }
        }
        return "index";
    }
}
