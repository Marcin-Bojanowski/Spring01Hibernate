package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/book")
public class ValidationController {
    public final Validator validator;
 @RequestMapping("/validate")
    public String validate(Model model){
     Book book=new Book();
     Set<ConstraintViolation<Book>> violations = validator.validate(book);
     if (!violations.isEmpty()) {
         model.addAttribute("violations",violations);
         for (ConstraintViolation<Book> constraintViolation : violations) {
             System.out.println(constraintViolation.getPropertyPath() + " "
                     + constraintViolation.getMessage());

         }

     }

     return "book/violations";
 }
}
