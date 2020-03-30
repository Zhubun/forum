package com.zhubun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlipayLoginController {

    private String scope = "auth_user";
    @Value("${ali.appId}")
    private String APP_ID;
    private String redirect_uri = "http://192.168.50.138:8080/oauth/redirect/ali";
    @GetMapping("/toAlipay")
    public String aliLogin(){
        String url = "openauth.alipay.com/oauth2/publicAppAuthorize.htm?" +
                "scope=" +scope+
                "&app_id=" +APP_ID+
                "&redirect_uri="+redirect_uri;
        return "redirect://"+url;
    }
}
