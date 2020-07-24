package com.zhubun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhubun.mapper.UserMapper;
import com.zhubun.model.UserDO;
import com.zhubun.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
}
