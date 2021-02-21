package com.freedom.code.mapper;

import com.freedom.common.dto.CustomerDTO;
import com.freedom.common.entity.CustomerDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/03 9:44
 */
@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  @Mapping( target = "name", source = "record.name" )
  @Mapping( target = ".", source = "record" )
  @Mapping( target = ".", source = "account" )
  CustomerDO customerDtoToCustomer(CustomerDTO customerDto);

}

