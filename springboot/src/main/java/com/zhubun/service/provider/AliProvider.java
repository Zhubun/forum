package com.zhubun.service.provider;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.zhubun.model.UserDO;
import com.zhubun.vo.dto.AliAccessTokenDTO;
import com.zhubun.vo.AliUserVO;
import com.zhubun.utils.UserToDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class AliProvider {
    @Autowired
    private AliAccessTokenDTO aliAccessTokenDTO;
    public String getAccessToken(String auth_code){
        AlipayClient alipayClient = new DefaultAlipayClient(aliAccessTokenDTO.getServerUrl(),aliAccessTokenDTO.getAppId(),aliAccessTokenDTO.getPrivateKey(),aliAccessTokenDTO.getFormat(),aliAccessTokenDTO.getCharset(),aliAccessTokenDTO.getAlipayPublicKey(),aliAccessTokenDTO.getSignType());
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode(auth_code);
        request.setGrantType("authorization_code");
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
            System.out.println(oauthTokenResponse.getAccessToken());
            return oauthTokenResponse.getAccessToken();
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return null;
    }

    public UserDO getUser(String AccessToken){
        AlipayClient alipayClient = new DefaultAlipayClient(aliAccessTokenDTO.getServerUrl(),aliAccessTokenDTO.getAppId(),aliAccessTokenDTO.getPrivateKey(),aliAccessTokenDTO.getFormat(),aliAccessTokenDTO.getCharset(),aliAccessTokenDTO.getAlipayPublicKey(),aliAccessTokenDTO.getSignType());
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        String auth_token = AccessToken;
        try {
            AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(request, auth_token);
            AliUserVO aliUser = new AliUserVO();
            aliUser.setNick_name(userinfoShareResponse.getNickName());
            aliUser.setUser_id(userinfoShareResponse.getUserId());
            System.out.println(aliUser);
            UserDO userDO = UserToDO.AliUser(aliUser);
            return userDO;
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return null;
    }
}
