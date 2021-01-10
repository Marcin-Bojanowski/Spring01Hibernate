package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService  authorService;

    @RequestMapping("book/all")
    public String getAll(Model model){
        model.addAttribute("books",bookService.getAllWithAuthors());
       return "book/all";
    }
    @RequestMapping("book/withPub")
    @ResponseBody
    public String getWithPublisher(){
        return bookService.getWithPublisher().toString();
    }
    @RequestMapping("book/withPub/{id}")
    @ResponseBody
    public String getWithPublisherId(@PathVariable long id){
        return bookService.getWithPublisherId(id).toString();
    }
    @RequestMapping("book/withAuth/{id}")
    @ResponseBody
    public String getWithAuthoeId(@PathVariable long id){
        return bookService.getWithAuthorId(id).toString();
    }
    @RequestMapping("book/all/{rating}")
    @ResponseBody
    public String getRatingList(@PathVariable int rating){
        return bookService.getRatingList(rating).toString();
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String saveBook() {
        Author author1=authorService.findById(1);
        Author author2=authorService.findById(2);

        Publisher publisher=new Publisher();
        publisher.setName("Helios");
        publisherService.savePublisher(publisher);
        Book book = new Book();
        book.setTitle("Czas Horusa");
        book.setRating(8);
        book.setDescription("Warhammer 40k");
        book.setPublisher(publisher);
        bookService.addAuthor(book,author1);
        bookService.addAuthor(book,author2);
        bookService.saveBook(book);
        return "dodano książkę";
    }
    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }
    @RequestMapping("/book/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable long id ) {
        Book book = bookService.findById(id);
        book.setDescription("Warhammer 40k (wersja II)");
        bookService.update(book);
        return book.toString();
    }
    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }

    @RequestMapping("book/count")
    @ResponseBody
    public String countBook(){
        return String.valueOf(bookService.countBook());
    }

    @RequestMapping("book/findByTitle/{title}")
    @ResponseBody
    public String findBookByTitle(@PathVariable String title){
        return bookService.findBooksByTitle(title).toString();
    }

//    @RequestMapping("/book/findByTitle/{title}")
//    @ResponseBody
//    public String findBooksByCategory(@PathVariable String name){
//        List<Book> books=bookService.getBooksByCategory()
//    }

    @RequestMapping("/book/findByCategoryId/{id}")
    @ResponseBody
    public String findBooksByCategoryId(@PathVariable long id){
        return bookService.findBookByCategoryId(id).toString();
    }
}
