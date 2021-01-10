package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BookService {

    private final BookDao bookDao;
    @Autowired
    private final BookRepository bookRepository;

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public Book findByIdWithAuthor(long id) {
        Book book = bookDao.findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public void addAuthor(Book book, Author author) {
        List<Author> authors = book.getAuthors();
        authors.add(author);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getAllWithAuthors() {
        List<Book> books = bookDao.getAll();
        books.forEach(book -> Hibernate.initialize(book.getAuthors()));
        return books;
    }

    public List<Book> getWithPublisher() {
        return bookDao.getWithPublisher();
    }

    public List<Book> getWithPublisherId(long id) {
        return bookDao.getWithPublisherId(id);
    }

    public List<Book> getWithAuthorId(long id) {
        return bookDao.getWithAuthorId(id);
    }

    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    public long countBook() {
        return bookRepository.count();
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.selectBooksByTitle(title);
//        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> getBooksByCategory(Category category) {
        return bookRepository.selectBooksByCategory(category);
//        return bookRepository.findBooksByCategory(category);
    }

    public List<Book> findBookByCategoryId(long id) {
        return bookRepository.findBooksByCategoryId(id);
    }
}
