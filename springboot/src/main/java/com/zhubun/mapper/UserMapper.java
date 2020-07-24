package com.zhubun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhubun.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

}
