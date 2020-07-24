package com.zhubun;

import com.zhubun.vo.dto.GitHubAccessTokenDTO;
import com.zhubun.service.provider.GitHubProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
@Autowired
GitHubAccessTokenDTO gitHubAccessTokenDTO;
    @Autowired
    GitHubProvider gitHubProvider;
    @Test
    void contextLoads() {
//        GitHubUser user = gitHubProvider.getUser("access_token=815ea55e44277cecfda44046753b1aacdde031da&scope=&token_type=bearer");
//        System.out.println(user);
//        System.out.println(user.getCreated_at());
        System.out.println(gitHubAccessTokenDTO);
    }

}
