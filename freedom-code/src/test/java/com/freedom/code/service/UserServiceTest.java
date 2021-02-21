package com.freedom.code.service;

import com.freedom.code.FreedomApplication;
import com.freedom.code.util.StringContextUtil;
import com.freedom.common.entity.UserDO;
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
class UserServiceTest {
  @Autowired
  private StringContextUtil stringContextUtil;

  @Test
  void selectById() {
    UserDO userDO111 = stringContextUtil.getContext().getBean("userDO111", UserDO.class);
    System.out.println(userDO111);
    //    UserDO userDO = userService.selectById(1345368146133819649L);
//    Assert.assertNotNull(userDO);

  }
}