package br.com.caelum.forum.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/my_blog?useSSL=false";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "toor";

    private String url;
    private String user;
    private String password;

    public ConnectionFactory() {
        this.url = System.getenv("MY_BLOG_DB_URL") != null ? System.getenv("MY_BLOG_DB_URL") : DEFAULT_URL;
        this.user = System.getenv("MY_BLOG_DB_USER") != null ? System.getenv("MY_BLOG_DB_USER") : DEFAULT_USER;
        this.password = System.getenv("MY_BLOG_DB_PASSWORD") != null ? System.getenv("MY_BLOG_DB_PASSWORD") : DEFAULT_PASSWORD;
    }

    public Connection create() {
        try {
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
