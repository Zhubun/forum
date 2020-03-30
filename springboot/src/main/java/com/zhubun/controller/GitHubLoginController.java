package com.zhubun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GitHubLoginController {
    @Value("${github.client_id}")
    private String client_id;
    @Value("${github.redirect_uri}")
    private String redirect_uri;
    @GetMapping("/toGitHub")
    public String toGitHubLogin(@RequestParam("state")double state){
        String url = "www.github.com/login/oauth/authorize?" +
                "client_id="+client_id+"&" +
                "redirect_uri="+redirect_uri+"&" +
                "state="+state;
        return "redirect://"+url;
    }
}
