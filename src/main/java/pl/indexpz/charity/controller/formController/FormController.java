package pl.indexpz.charity.controller.formController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.repository.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/form")
@Slf4j
@RequiredArgsConstructor
public class FormController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public String prepareForm(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "/form";
    }


}
