package java15.dao;


import java15.model.Author;

import java.util.List;

public interface AuthorDao {

    // TODO crate table
    void createTableAuthor();

    // TODO  add Author
    String saveAuthor(Author author);

    // TODO  getAllAuthor Author
    List<Author> getAllAuthor();

    // TODO  getById Author
    Author getById(Long authorId);

    // TODO  update Author
    String updateAuthor (Long authorId,Author newAuthor);

    // TODO  delete Author
    void deleteAuthor(Long authorId);

    // TODO  dropTableAuthor Author
    void dropTableAuthor();

    // TODO  cleanTableAuthor Author
    void cleanTableAuthor();

    // TODO  sortByDateOfBirth Author
    List<Author> sortByDateOfBirth();

}
