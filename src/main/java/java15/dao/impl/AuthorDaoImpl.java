package java15.dao.impl;


import java15.config.JdbcConfig;
import java15.dao.AuthorDao;
import java15.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private final Connection connection  = JdbcConfig.getConnection();

    @Override
    public void createTableAuthor() {
        String sql = """
                create table if not exists authors (
                id serial primary key,
                first_name varchar not null,
                last_name varchar not null,
                email varchar not null,
                country varchar not null,
                date_of_birth date
                );
                """;
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Successfully created table author !");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String saveAuthor(Author author) {
         String sql = """
                 insert into authors (first_name, last_name, email, country, date_of_birth)
                 values (?, ?, ?, ?, ?)
                 """;
         try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setString(1, author.getFirstName());
             preparedStatement.setString(2, author.getLastName());
             preparedStatement.setString(3, author.getEmail());
             preparedStatement.setString(4, author.getCountry());
             preparedStatement.setDate(5, Date.valueOf(author.getDateOfBirth()));
             preparedStatement.executeUpdate();
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }

        return "Successfully saved author !";
    }

    @Override
    public List<Author> getAllAuthor() {
        List<Author> authors = new ArrayList<>();
        String sql = "select * from authors";

        try(PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authors.add(new Author(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getDate("date_of_birth").toLocalDate()
                        ));
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
    }

    @Override
    public Author getById(Long authorId) {
        Author authors = null;
        String sql = "select * from authors where id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Author  author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setEmail(resultSet.getString("email"));
                author.setCountry(resultSet.getString("country"));
                author.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                return author;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return authors;
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
         String sql = """
                 update authors set first_name = ?,
                 last_name = ?,
                 email = ? ,
                 country = ?, 
                 date_of_birth = ?
                 where id = ?
                 """;
         try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
              preparedStatement.setString(1, newAuthor.getFirstName());
              preparedStatement.setString(2, newAuthor.getLastName());
              preparedStatement.setString(3, newAuthor.getEmail());
              preparedStatement.setString(4, newAuthor.getCountry());
              preparedStatement.setDate(5, Date.valueOf(newAuthor.getDateOfBirth()));
              preparedStatement.setLong(6, authorId);
              preparedStatement.executeUpdate();

         }catch (SQLException e) {
             System.out.println(e.getMessage());
         }
        return "Successfully updated author !";
    }

    @Override
    public void deleteAuthor(Long authorId) {
        String sql = "delete from authors where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
          preparedStatement.setLong(1,authorId);
          int rows = preparedStatement.executeUpdate();
          if (rows > 0){
              System.out.println("Successfully deleted author !");
          }else {
              System.out.println(" not found  "+ authorId);
          }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropTableAuthor() {

        String sql = "drop table if exists  authors cascade ";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.executeUpdate();
            System.out.println("Successfully dropped table authors !");
        }catch (SQLException e) {
            System.out.println(e.getMessage() + "Error dropping table authors ! ");
        }



    }

    @Override
    public void cleanTableAuthor() {
        String sql = "Truncate table authors cascade";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            System.out.println("Successfully cleaned table author !");
        }catch (SQLException e) {
            System.out.println(e.getMessage() + "Error cleaning table author !" );
        }

    }

    @Override
    public List<Author> sortByDateOfBirth() {
        List<Author> authors = new ArrayList<>();

        String sql = "select * from authors order by date_of_birth desc";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authors.add(new Author(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getDate("date_of_birth").toLocalDate()
                ));
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
    }


}
