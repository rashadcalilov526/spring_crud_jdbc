package spring.crud.jdbc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import spring.crud.jdbc.dao.entity.UserEntity;
import spring.crud.jdbc.model.dto.UserDto;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDto mapEntityToDto(UserEntity entity);
}
