package com.zhubun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class UserDO {
    String accountId;
    String name;
    String token;
    Date date;
    Date modified;
}
