package com.zhubun.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
@ConfigurationProperties("ali")
public class AliAccessTokenDTO {
    private String appId;
    private String redirectUri;
    private String charset;
    private String privateKey;
    private String alipayPublicKey;
    private String serverUrl;
    private String format;
    private String signType;

}
