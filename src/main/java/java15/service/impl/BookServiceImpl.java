package java15.service.impl;


import java15.config.JdbcConfig;
import java15.dao.BookDao;
import java15.dao.impl.BookDaoImpl;
import java15.service.BookService;

import java.sql.Connection;

public class BookServiceImpl implements BookService {

     private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void createTableBook() {
        bookDao.createTableBook();
    }
}
