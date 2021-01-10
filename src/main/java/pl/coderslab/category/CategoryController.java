package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping("/add/{name}")
    @ResponseBody
    public String addcategory(@PathVariable String name) {
        Category category = new Category();
        category.setName(name);
        return categoryService.addCategory(category).toString();
    }
}