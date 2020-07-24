package com.zhubun.controller;

import com.zhubun.model.UserDO;
import com.zhubun.mapper.UserMapper;
import com.zhubun.service.UserService;
import com.zhubun.service.provider.AliProvider;
import com.zhubun.service.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @Autowired
    private AliProvider aliProvider;
    @Autowired
    UserService userService;

    @GetMapping("/oauth/redirect/github")
    public String github(@RequestParam(name = "code")String code,
                         @RequestParam(name = "state")String state,
                         HttpServletRequest request,
                         HttpServletResponse response){
        //用okhttp发送post请求到github获取AccessToken
        String accessToken = gitHubProvider.getAccessToken(code,state);
        //用okhttp发送AccessToken,get请求到GitHub获取用户的详细信息,返回用户信息json
        UserDO user = gitHubProvider.getUser(accessToken);
        if(user!=null){
            //登录成功,写cookie和session
            userService.save(user);
            Cookie cookie = new Cookie("token",user.getToken());
            cookie.setPath("/");
            response.addCookie(cookie);
            System.out.println(user);
            return "redirect:/index";

        }else {
            return "redirect:/index";
        }
    }

    @GetMapping("/oauth/redirect/ali")
    public String ali(@RequestParam(name = "auth_code")String auth_code,HttpServletRequest request){
        String accessToken = aliProvider.getAccessToken(auth_code);
        UserDO user = aliProvider.getUser(accessToken);
        if(user!=null){
            //登录成功,写cookie和session
            request.getSession().setAttribute("user",user);
            System.out.println(user);
            return "redirect:/index";

        }else {
            return "redirect:/index";
        }
    }
}
