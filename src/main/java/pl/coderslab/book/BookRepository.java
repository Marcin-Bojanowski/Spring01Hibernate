package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(long id);

    List<Book> findBooksByAuthorsId(Author authors_id);

    @Query("select b from Book b where b.title=?1")
    List<Book> selectBooksByTitle(String title);

    @Query("select b from Book b where b.category=?1")
    List<Book> selectBooksByCategory(Category category);
}
