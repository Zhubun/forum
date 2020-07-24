package com.zhubun.vo.dto;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "github")
public class GitHubAccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String code;
    private String state;
}
