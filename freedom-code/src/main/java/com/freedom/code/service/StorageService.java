package com.freedom.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.freedom.common.entity.StorageDO;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/12/29 23:34
 */
public interface StorageService extends IService<StorageDO> {

  int deduct(Long productId, Long num);
}
