package spring.crud.jdbc.dao.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.crud.jdbc.dao.entity.UserEntity;
import spring.crud.jdbc.dao.repository.mapper.UserRowMapper;

import java.util.Optional;

import static spring.crud.jdbc.dao.repository.sql.QueryBuilder.buildSqlToDeleteUser;
import static spring.crud.jdbc.dao.repository.sql.QueryBuilder.buildSqlToGetUserById;
import static spring.crud.jdbc.dao.repository.sql.QueryBuilder.buildSqlToInsertUser;
import static spring.crud.jdbc.dao.repository.sql.QueryBuilder.buildSqlToUpdateUserName;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;


    public Optional<UserEntity> getById(Long id) {
        return jdbcTemplate.query(buildSqlToGetUserById(id), userRowMapper).stream().findFirst();
    }

    public void updateUserName(String name, Long id) {
        jdbcTemplate.update(buildSqlToUpdateUserName(name, id));
    }

    public void insertUser(String name, Integer age) {
        jdbcTemplate.update(buildSqlToInsertUser(name, age));
    }

    public void deleteUser(Long id) {
        jdbcTemplate.update(buildSqlToDeleteUser(id));
    }
}
