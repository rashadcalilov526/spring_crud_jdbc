package spring.crud.jdbc.dao.repository.sql;

public abstract class Query {
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = '%s' ";

    public static final String UPDATE_USER_NAME = "UPDATE users SET name = '%s' WHERE id = '%s' ";

    public static final String INSERT_USER = "INSERT INTO users(name,age) VALUES ('%s','%s') ";

    public static final String DELETE_USER = "DELETE FROM users WHERE id = '%s' ";
}
