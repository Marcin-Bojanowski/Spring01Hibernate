package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/book")
public class BookFormController {
    private final Validator validator;
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
private final CategoryService categoryService;
    @ModelAttribute("publishers")
    public List<Publisher> getAllPublishers() {
        return publisherService.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/form")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()){
            return "book/form";
        }

        bookService.saveBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam long id, Model model) {
        model.addAttribute("book", bookService.findByIdWithAuthor(id));
        return "book/form";

    }

    @PostMapping("/edit")
    public String editBookForm(@RequestParam long id, @ModelAttribute Book book) {
        bookService.update(book);
        return "redirect:/book/all";
    }

    @GetMapping("/confirmDelete")
    public String confirmDelete(@RequestParam long id, Model model) {
        model.addAttribute("id", id);
        return "book/confirmDelete";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam long id){
        bookService.delete(bookService.findById(id));
        return "redirect:/book/all";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return  categoryService.getAll();
    }
}
