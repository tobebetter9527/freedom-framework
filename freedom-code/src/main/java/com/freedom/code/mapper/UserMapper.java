package com.freedom.code.mapper;

import com.freedom.code.annotation.ToEntity;
import com.freedom.common.dto.RoleDTO;
import com.freedom.common.dto.UserDTO;
import com.freedom.common.dto.UserRoleDTO;
import com.freedom.common.dto.UserVO;
import com.freedom.common.entity.RoleDO;
import com.freedom.common.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/03 9:44
 */
@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "roleDTO", source = "roleDO")
  UserDTO doToDto(UserDO userDO, @MappingTarget UserDTO userDTO);


  @Mapping(target = "username", source = "userDO.name")
  @Mapping(target = "roleName", source = "roleDO.name")
  @Mapping(target = "age", source = "myAge")
  UserRoleDTO doToUserRoleDto(UserDO userDO, RoleDO roleDO, Integer myAge);

  @Mapping(target = "roleDTO", source = "roleDO")
  UserDTO doToDto(UserDO userDO);

  @ToEntity
  @Mapping(target = "userId", source = "id")
  @Mapping(target = "myAge", source = "age")
  UserVO doToVo(UserDO userDO);

  default RoleDTO doToDto(RoleDO roleDO) {
    if (roleDO == null) {
      return null;
    }
    RoleDTO roleDTO = new RoleDTO();
    roleDTO.setId(roleDO.getId());
    roleDTO.setName(roleDO.getName());
    return roleDTO;
  }

  UserDO dtoToDo(UserDTO userDTO);

}
