package com.freedom.code.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.freedom.code.repository.StorageRepository;
import com.freedom.common.entity.StorageDO;
import io.seata.core.context.RootContext;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/12/27 21:44
 */
@Slf4j
@Service
public class StorageServiceImpl extends ServiceImpl<StorageRepository, StorageDO> implements StorageService {

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int deduct(Long productId, Long num) {
    String xid = RootContext.getXID();
    log.info("deduct xid:{}", xid);
    LambdaQueryWrapper<StorageDO> query = new LambdaQueryWrapper<>();
    query.eq(StorageDO::getProductId, productId);
    List<StorageDO> storageDOS = baseMapper.selectList(query);
    if (CollectionUtil.isNotEmpty(storageDOS)) {
      StorageDO storageDO = storageDOS.get(0);
      storageDO.setProductNum(storageDO.getProductNum() - num);
      return baseMapper.updateById(storageDO);
    }

    return 0;
  }
}
