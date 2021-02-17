package com.freedom.code.mapper;

import com.freedom.code.annotation.ToEntity;
import com.freedom.code.dto.CustomerDTO;
import com.freedom.code.dto.RoleDTO;
import com.freedom.code.dto.UserDTO;
import com.freedom.code.dto.UserRoleDTO;
import com.freedom.code.dto.UserVO;
import com.freedom.code.entity.CustomerDO;
import com.freedom.code.entity.RoleDO;
import com.freedom.code.entity.UserDO;
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

