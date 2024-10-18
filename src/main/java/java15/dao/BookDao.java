package java15.dao;


import java15.model.Book;

public interface BookDao {
   void createTableBook();
    String saveBook(Book book);
}
