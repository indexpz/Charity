package pl.indexpz.charity.controller.formController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
@Slf4j
public class FormController {

    @GetMapping
    public String prepareForm(){
        return "form/form";
    }

}
