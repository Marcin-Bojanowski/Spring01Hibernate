package pl.coderslab.proposition;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.book.Book;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = Proposition.TABLE)
public class Proposition extends Book {
    public final static String TABLE = "propositions";

  

}
