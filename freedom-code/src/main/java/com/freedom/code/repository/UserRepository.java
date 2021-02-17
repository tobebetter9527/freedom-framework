package com.freedom.code.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.freedom.code.entity.UserDO;
import java.util.List;

/**
 * @author tobebetter9527
 * @create 2020/12/27 20:22
 */
public interface UserRepository extends BaseMapper<UserDO> {

 List<UserDO> listAll();
}
