package com.freedom.code.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.freedom.code.service.UserService;
import com.freedom.code.strategy.CsmsStrategyContext;
import com.freedom.common.dto.UserDTO;
import com.freedom.common.entity.UserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tobebetter9527
 * @create 2020/12/28 0:14
 */
@Api(tags = {"用户接口"})
@RestController
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private CsmsStrategyContext csmsStrategyContext;

  @ApiOperation(value = "根据ID查询用户", notes = "查询用户")
  @GetMapping("/getById")
  public UserDO getById(@ApiParam(value = "用户id") @RequestParam("id") Long id) {
    return userService.selectById(id);
  }

  @ApiOperation(value = "根据ID查询用户", notes = "查询用户")
  @GetMapping("/doCsmsStrategy")
  public String doCsmsStrategy(@ApiParam(value = "用户id") @RequestParam("id") Long id) {
    return csmsStrategyContext.doCsmsStrategy(id);
  }

  @ApiOperation(value = "分页查询", notes = "分页查询")
  @GetMapping("/page")
  public Page getPage(Page page, UserDO userDO) {
    return userService.page(page, Wrappers.query(userDO));
  }

  @ApiOperation(value = "新增用户", notes = "新增用户")
  @PostMapping("/save")
  public void save(@ApiParam(value = "用户信息") @RequestBody UserDTO userDTO) {
    userService.saveUserDTO(userDTO);
  }

  @ApiOperation(value = "修改用户", notes = "修改用户")
  @PostMapping("/update")
  public void update(@RequestBody UserDO userDO) {
    userService.save(userDO);
  }
}
