package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("select b from Book b");
        return query.getResultList();

    }
    public List<Book> getWithPublisher() {
        Query query = entityManager.createQuery("select b from Book b where b.publisher is not null ");
        return query.getResultList();

    }
    public List<Book> getWithPublisherId(long id) {
        Query query = entityManager.createQuery("select b from Book b where b.publisher.id=:id");
        query.setParameter("id",id);
        return query.getResultList();

    }
    public List<Book> getWithAuthorId(long id) {
        Query query = entityManager.createQuery("select b from Book b join fetch b.authors a where a.id=:id");
        query.setParameter("id",id);
        return query.getResultList();

    }
    public List<Book>getRatingList(int rating){
        Query query=entityManager.createQuery("select b from Book b where b.rating=:rating");
        query.setParameter("rating",rating);
        return query.getResultList();
    }
}
