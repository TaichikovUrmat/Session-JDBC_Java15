package java15.service.impl;


import java15.dao.impl.AuthorDaoImpl;
import java15.model.Author;
import java15.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorDaoImpl authorDao = new AuthorDaoImpl();
    @Override
    public void createTableAuthor() {
         authorDao.createTableAuthor();
    }

    @Override
    public String saveAuthor(Author author) {
        return authorDao.saveAuthor(author);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorDao.getAllAuthor();
    }

    @Override
    public Author getById(Long authorId) {
        return authorDao.getById(authorId);
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        return authorDao.updateAuthor(authorId, newAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorDao.deleteAuthor(authorId);

    }

    @Override
    public void dropTableAuthor() {
        authorDao.dropTableAuthor();
    }

    @Override
    public void cleanTableAuthor() {
      authorDao.cleanTableAuthor();
    }

    @Override
    public List<Author> sortByDateOfBirth() {
        return authorDao.sortByDateOfBirth();
    }

}
