package com.freedom.code.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.freedom.code.repository.UserRepository;
import com.freedom.common.entity.UserDO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/12/27 21:44
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, UserDO> implements UserService {

  @Override
  public List<UserDO> listAll() {
    return baseMapper.listAll();
  }

  @Override
  public UserDO selectById(Long id) {
    if (id != null) {
      if (id.equals(1L)) {
        return null;
      }
    }
    return baseMapper.selectById(id);
  }
}
