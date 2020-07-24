package com.zhubun.utils;

import com.zhubun.vo.AliUserVO;
import com.zhubun.vo.GitHubUserVO;
import com.zhubun.model.UserDO;

import java.sql.Date;
import java.util.UUID;

public class UserToDO {
    public static UserDO githubUser(GitHubUserVO gitHubUser){
        UserDO userDO = new UserDO();
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replaceAll("-", "");
        userDO.setAccountId(s);
        userDO.setName(gitHubUser.getUsername());
        userDO.setToken(s);
        userDO.setDate(gitHubUser.getCreated_at());
        userDO.setModified(new Date(System.currentTimeMillis()));
        return userDO;
    }
    public static UserDO AliUser(AliUserVO aliUser){
        UserDO userDO = new UserDO();
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replaceAll("-", "");
        userDO.setAccountId(s);
        userDO.setName(aliUser.getNick_name());
        userDO.setToken(s);
        userDO.setDate(new Date(System.currentTimeMillis()));
        userDO.setModified(new Date(System.currentTimeMillis()));
        return userDO;
    }
}
