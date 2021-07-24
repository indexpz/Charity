package pl.indexpz.charity.controller.formController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.service.CategoryServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/form")
@Slf4j
@RequiredArgsConstructor
public class FormController {

    private final CategoryServiceInterface categoryServiceInterface;

    @GetMapping
    public String prepareForm(Model model) {
        List<Category> allCategories = categoryServiceInterface.getAllCategories();
        List<String> names = new ArrayList<>();
        for (Category c : allCategories) {
            names.add(c.getName());
            System.out.println(c.getId() + " " + c.getName());
        }
        model.addAttribute("categories", allCategories);
        log.info("" + categoryServiceInterface.getAllCategories());
        return "form/form";
    }


}
