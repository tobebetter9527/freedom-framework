package com.freedom.code.service;

import static org.junit.jupiter.api.Assertions.*;

import com.freedom.code.FreedomApplication;
import com.freedom.code.entity.UserDO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/02/17 10:23
 */
@ActiveProfiles("test")
@SpringBootTest(classes = FreedomApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class UserServiceTest {
  @Autowired
  private UserService userService;

  @Test
  void selectById() {
    UserDO userDO = userService.selectById(1345368146133819649L);
    Assert.assertNotNull(userDO);
  }
}