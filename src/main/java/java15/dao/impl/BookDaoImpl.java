package java15.dao.impl;

import java15.config.JdbcConfig;
import java15.dao.BookDao;
import java15.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDaoImpl implements BookDao {

    private final Connection connection = JdbcConfig.getConnection();

    @Override
    public void createTableBook() {

        String sql = """
                create table if not exists books(
                id serial primary key,
                name varchar(55),
                country varchar(55),
                publisher varchar(55),
                price int,
                authors_id int references authors(id));
                """;
        try (Statement statement = connection.createStatement()){
            statement.execute(sql);
            System.out.println("Successfully created table book");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }
    @Override
    public String saveBook(Book book) {
        return "";
    }
}
