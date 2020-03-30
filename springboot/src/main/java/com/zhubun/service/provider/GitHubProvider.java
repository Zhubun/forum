package com.zhubun.service.provider;

import com.zhubun.model.UserDO;
import com.zhubun.vo.dto.GitHubAccessTokenDTO;
import com.zhubun.vo.GitHubUserVO;
import com.zhubun.utils.UserToDO;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
    @Autowired
    GitHubAccessTokenDTO gitHubAccessTokenDTO;

    //用okhttp发送post请求到github获取AccessToken
    public String getAccessToken(String code,String state) {
        gitHubAccessTokenDTO.setCode(code);
        gitHubAccessTokenDTO.setState(state);
        System.out.println(gitHubAccessTokenDTO);
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String json = com.alibaba.fastjson.JSON.toJSONString(gitHubAccessTokenDTO);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String AccessToken = response.body().string();
            System.out.println(AccessToken);
            return AccessToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //用okhttp发送get请求到GitHub获取用户的详细信息,返回用户信息json
    public UserDO getUser(String AccessToken){
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?"+AccessToken)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            String userjson = response.body().string();
            GitHubUserVO gitHubUser = com.alibaba.fastjson.JSON.parseObject(userjson, GitHubUserVO.class);
            System.out.println(gitHubUser);
            UserDO userDO = UserToDO.githubUser(gitHubUser);
            return userDO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
