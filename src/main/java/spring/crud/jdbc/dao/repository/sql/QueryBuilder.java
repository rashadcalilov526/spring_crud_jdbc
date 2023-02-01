package spring.crud.jdbc.dao.repository.sql;

import static spring.crud.jdbc.dao.repository.sql.Query.DELETE_USER;
import static spring.crud.jdbc.dao.repository.sql.Query.GET_USER_BY_ID;
import static spring.crud.jdbc.dao.repository.sql.Query.INSERT_USER;
import static spring.crud.jdbc.dao.repository.sql.Query.UPDATE_USER_NAME;

public abstract class QueryBuilder {

    public static String buildSqlToGetUserById(Long id) {
        return String.format(GET_USER_BY_ID, id);
    }

    public static String buildSqlToUpdateUserName(String name, Long id) {
        return String.format(UPDATE_USER_NAME, name, id);
    }

    public static String buildSqlToInsertUser(String name, Integer age) {
        return String.format(INSERT_USER, name, age);
    }

    public static String buildSqlToDeleteUser(Long id) {
        return String.format(DELETE_USER, id);
    }
}
