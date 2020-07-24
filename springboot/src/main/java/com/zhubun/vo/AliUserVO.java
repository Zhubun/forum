package com.zhubun.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AliUserVO {
    String nick_name;
    String user_id;
    public String getUsername(){
        return nick_name;
    }
}
