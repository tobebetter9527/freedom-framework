package com.freedom.code.mapper;

import com.freedom.common.dto.CarDTO;
import com.freedom.common.entity.CarDO;
import java.util.List;
import org.mapstruct.Mapper;
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
