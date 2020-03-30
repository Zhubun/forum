package com.zhubun.provider;

import com.alibaba.fastjson.JSON;
import com.zhubun.pojo.AccessTokenDTO;
import com.zhubun.pojo.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String json = com.alibaba.fastjson.JSON.toJSONString(accessTokenDTO);
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

    public GitHubUser getUser(String AccessToken){
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?"+AccessToken)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            String userjson = response.body().string();
            GitHubUser gitHubUser = com.alibaba.fastjson.JSON.parseObject(userjson, GitHubUser.class);
            System.out.println(gitHubUser);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
