package pl.indexpz.charity.controller.formController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.model.Donation;
import pl.indexpz.charity.domain.model.Institution;
import pl.indexpz.charity.domain.service.CategoryServiceInterface;
import pl.indexpz.charity.domain.service.DonationServiceInterface;
import pl.indexpz.charity.domain.service.InstitutionServiceInterface;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/form")
@Slf4j
@RequiredArgsConstructor
public class FormController {

    private final CategoryServiceInterface categoryServiceInterface;
    private final DonationServiceInterface donationServiceInterface;
    private final InstitutionServiceInterface institutionServiceInterface;

//    @ModelAttribute(name = "cate")
//    public List<String> meterUnit() {
//        List<Category> categoryList =  categoryServiceInterface.getAllCategories();
//        List<String> nameList = new ArrayList<>();
//        for (Category c : categoryList             ) {
//            nameList.add(c.getName());
//        }
//        return nameList;
//    }

    @GetMapping
    public String prepareCategoryForm(HttpSession session, Model model) {
        List<Category> allCategories = categoryServiceInterface.getAllCategories();
        List<Institution> allInstitution = institutionServiceInterface.getAllInstitutions();


        model.addAttribute("categories", allCategories);
        model.addAttribute("institutions", allInstitution);
        model.addAttribute("donations", new Donation());
        log.info("" + categoryServiceInterface.getAllCategories());

        Donation donation = new Donation();
        session.setAttribute("saveDonation", donation);
        return "form/form";
    }


    @PostMapping
    public String processCategoryForm(@Valid Controller controller, BindingResult bindings){
        if(bindings.hasErrors()){
            return "form/form";
        }


        return "form/form";
    }

}
