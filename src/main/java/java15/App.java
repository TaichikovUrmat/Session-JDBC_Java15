package java15;

import java15.model.Author;
import java15.service.AuthorService;
import java15.service.BookService;
import java15.service.impl.AuthorServiceImpl;
import java15.service.impl.BookServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BookService  bookService = new BookServiceImpl();
//        bookService.createTableBook();




        AuthorService authorService = new AuthorServiceImpl();
//        authorService.createTableAuthor();
//        authorService.saveAuthor(new Author("Tolomushov", "Urmat" ,"baisal@gmail.com",
//                "KG",LocalDate.of(2006,9,6)));
//        System.out.println(authorService.getAllAuthor());
//        System.out.println(authorService.getById(1L));
//        System.out.println(authorService.updateAuthor(3L, new Author("Narynbek uulu", "Babakhan", "b@gmail.com",
//                "KG", LocalDate.of(1993, 10, 11))));
//        authorService.deleteAuthor(5L);
//        System.out.println(authorService.sortByDateOfBirth());
//        authorService.cleanTableAuthor();
         authorService.dropTableAuthor();
    }
}
