package spring.crud.jdbc.dao.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import spring.crud.jdbc.dao.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet rs, int i) throws SQLException {
        return UserEntity.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .age(rs.getObject("age", Integer.class))
                .build();
    }
}
