package com.freedom.code.mapper;

import com.freedom.code.annotation.ToEntity;
import com.freedom.code.dto.CarDTO;
import com.freedom.code.dto.RoleDTO;
import com.freedom.code.dto.UserDTO;
import com.freedom.code.dto.UserRoleDTO;
import com.freedom.code.dto.UserVO;
import com.freedom.code.entity.CarDO;
import com.freedom.code.entity.RoleDO;
import com.freedom.code.entity.UserDO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/03 9:44
 */
@Mapper(componentModel = "spring")
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  CarDTO dtoToDo(CarDO carDO);

  List<CarDTO> doToDtos(List<CarDO> carDOS);
}
