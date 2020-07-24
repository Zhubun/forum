package com.zhubun.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GitHubUserVO {
    @JSONField(name = "login")
    private String username;
    @JSONField(name = "id")
    private long userid;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date created_at;
}
