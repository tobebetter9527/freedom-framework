package com.freedom.code.service;

import com.freedom.code.FreedomApplication;
import com.freedom.code.util.StringContextUtil;
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
public class UserServiceTest {
  @Autowired
  private StringContextUtil stringContextUtil;

  @Test
  public void selectById() {
    //UserDO userDO111 = stringContextUtil.getContext().getBean("userDO111", UserDO.class);
  }

  @Test
  public void testRedisServer() {
//    System.out.println("Host="+ redisServer.getHost());
//    System.out.println("Base="+ redisServer.getBase());
//    System.out.println("BindPort="+ redisServer.getBindPort());

  }

}