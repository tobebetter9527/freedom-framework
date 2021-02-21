package com.freedom.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.freedom.common.entity.UserDO;
import java.util.List;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/12/29 23:34
 */
public interface UserService extends IService<UserDO> {

  List<UserDO> listAll();

  UserDO selectById(Long id);
}
