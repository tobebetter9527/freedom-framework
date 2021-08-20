package com.freedom.code.service;

import com.freedom.code.FreedomApplication;
import com.freedom.code.util.SpringContextUtil;
import com.freedom.common.entity.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * @author tobebetter9527
 * @description user测试类
 * @create 2021/02/17 10:23
 */
@SpringBootTest(classes = FreedomApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

  @Autowired
  private SpringContextUtil springContextUtil;
  @Autowired
  private UserService userService;

  @Test
  public void selectById() {
    //UserDO userDO111 = stringContextUtil.getContext().getBean("userDO111", UserDO.class);
    UserDO byId = userService.getById("123456");
    System.out.println(byId);
  }

  @Test
  public void testRedisServer() {
    //    System.out.println("Host="+ redisServer.getHost());
    //    System.out.println("Base="+ redisServer.getBase());
    //    System.out.println("BindPort="+ redisServer.getBindPort());

  }

}