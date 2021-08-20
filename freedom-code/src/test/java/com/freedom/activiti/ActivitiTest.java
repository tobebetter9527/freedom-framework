package com.freedom.activiti;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.freedom.code.FreedomApplication;
import com.freedom.code.service.UserService;
import com.freedom.code.util.SpringContextUtil;
import com.freedom.common.dto.UserDTO;
import com.freedom.common.entity.UserDO;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author tobebetter9527
 * @description user测试类
 * @create 2021/02/17 10:23
 */
@ActiveProfiles("test")
@SpringBootTest(classes = FreedomApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ActivitiTest {

  @Autowired
  private SpringContextUtil springContextUtil;
  @Autowired
  private UserService userService;


  @Test
  public void insertUserDO() throws Exception {
    UserDTO userDTO = new UserDTO();
    userDTO.setName("zhangsan");
    userDTO.setAge(27);
    userDTO.setEmail("123@qq.com");

    userService.saveUserDTO(userDTO);

  }

}