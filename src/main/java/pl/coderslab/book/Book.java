package pl.coderslab.book;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = Book.TABLE)
public class Book {
    public final static String TABLE = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;
    @ManyToOne
    @NotNull
    private Publisher publisher;
    @ManyToMany
    @NotEmpty
    private List<Author> authors;
    @Min(1)
    @NotNull
    private int pages;

    @ManyToOne
    private Category category;


//    public Book() {
//        authors = new ArrayList<>();
//    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
