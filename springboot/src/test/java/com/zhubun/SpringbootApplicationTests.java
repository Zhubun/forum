package com.zhubun;

import com.zhubun.pojo.AccessTokenDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
@Autowired
    AccessTokenDTO accessTokenDTO;
    @Test
    void contextLoads() {
        System.out.println(accessTokenDTO.getClient_id());
    }

}
