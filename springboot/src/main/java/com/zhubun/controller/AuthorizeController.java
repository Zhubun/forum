package com.zhubun.controller;

import com.zhubun.pojo.AccessTokenDTO;
import com.zhubun.provider.GitHubProvider;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @Autowired
    private AccessTokenDTO accessTokenDTO;
    @RequestMapping("/oauth/redirect")
    public String callback(@RequestParam(name = "code")String code){
        String state = Math.random()*10+"";
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        System.out.println(accessTokenDTO);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        gitHubProvider.getUser(accessToken);
        return "index";
    }
}
