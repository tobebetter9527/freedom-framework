package com.freedom.code.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.freedom.code.annotation.StartTaskRun;
import com.freedom.code.mapper.UserMapper;
import com.freedom.code.repository.UserRepository;
import com.freedom.code.strategy.CsmsStrategy;
import com.freedom.common.dto.OrderDTO;
import com.freedom.common.dto.UserDTO;
import com.freedom.common.entity.UserDO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/12/27 21:44
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserRepository, UserDO> implements UserService, CsmsStrategy {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;
  @Value("${server.port}")
  private Integer port;
  @Autowired
  private OrderFeignService orderFeignService;


  @Override
  @Transactional(rollbackFor = Exception.class)
  public UserDO saveUserDTO(UserDTO userDTO) {
    UserDO userDO = UserMapper.INSTANCE.dtoToDo(userDTO);
    userRepository.insert(userDO);

    UserDO userDO1 = userService.selectById(userDO.getId());
    return userDO1;
  }

  @StartTaskRun(businessType = 5)
  @Override
  @Transactional(rollbackFor = Exception.class)
  public UserDO selectById(Long id) {
    if (id != null) {
      if (id.equals(1L)) {
        return null;
      }
    }
    OrderDTO orderDTO = orderFeignService.getById(123456L);
    log.info("selectById orderDTO:{}", orderDTO);

    UserDO userDO = baseMapper.selectById(id);
    userDO.setPort(port);
    return userDO;
  }

  @Override
  public List<UserDO> listAll() {
    return baseMapper.listAll();
  }

  @StartTaskRun(businessType = 5)
  @StartTaskRun(businessType = 6)
  @Override
  @Transactional(rollbackFor = Exception.class)
  public String doCsmsStrategy(Long id) {
    UserDO userDO = baseMapper.selectById(id);
    return userDO.getId().toString();
  }
}
