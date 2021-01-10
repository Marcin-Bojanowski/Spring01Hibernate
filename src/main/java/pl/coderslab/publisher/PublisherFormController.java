package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/publisher")
public class PublisherFormController {
    private final PublisherService publisherService;

    @GetMapping("/form")
    public String addPublisher(Model model){
        model.addAttribute("publisher",new Publisher());
        return "publisher/form";
    }

    @PostMapping("/form")
    public String savePublisher(@Valid Publisher publisher, BindingResult result){
        if (result.hasErrors()){
            return "publisher/form";
        }
        publisherService.savePublisher(publisher);
        return "redirect:all";
    }

    @RequestMapping("/all")
    public String getAll(Model model){
        model.addAttribute("publishers",publisherService.getAll());
        return "publisher/all";
    }

    @GetMapping("/edit")
    public String editPublisher(@RequestParam long id, Model model){
        model.addAttribute("publisher",publisherService.findById(id));
        return "publisher/form";
    }

    @PostMapping("/edit")
    public String editPublisher(@Valid Publisher publisher, BindingResult result){
        if (result.hasErrors()){
            return "publisher/form";
        }
        publisherService.update(publisher);
        return "redirect:/publisher/all";
    }
}
