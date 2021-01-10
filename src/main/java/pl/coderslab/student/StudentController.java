package pl.coderslab.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class StudentController {

    @GetMapping("/student")
    public String showFormStudent(Model model){
        model.addAttribute("student",new Student());
        return "student/form";
    }

    @PostMapping("/student")
    @ResponseBody
    public String printStudents(@ModelAttribute Student student){
        return student.toString();
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("skills")
    public List<String> skills() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        String[] a = new String[] {"gym", "games", "photography", "programming"};
        return Arrays.asList(a);
    }
}
