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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/form")
@Slf4j
@RequiredArgsConstructor
public class FormController {

    private final CategoryServiceInterface categoryServiceInterface;
    private final DonationServiceInterface donationServiceInterface;
    private final InstitutionServiceInterface institutionServiceInterface;


    @GetMapping("/form")
    public String prepareForm(HttpSession session, Model model) {
        List<Category> allCategories = categoryServiceInterface.getAllCategories();
        allCategories.sort(Comparator.comparing(Category::getId));
        List<Institution> allInstitution = institutionServiceInterface.getAllInstitutions();
        Donation donation = new Donation();

        model.addAttribute("categories", allCategories);
        model.addAttribute("institutions", allInstitution);
        model.addAttribute("donation", donation);

        session.setAttribute("saveDonation", donation);

        log.info("" + categoryServiceInterface.getAllCategories());
        log.info("" + donation);
        return "form/form";
    }


    @PostMapping("/form")
    public String procesForm(@Valid Donation donation, BindingResult bindings, HttpSession session) {
        if (bindings.hasErrors()) {
            return "form/form";
        }
        session.getAttribute("saveDonation");

        return "form/form_summary";
    }

    @PostMapping("/form_summary")
    public String processFormSummary(@Valid Donation donation, BindingResult bindings, HttpSession session, Model model) {
        if (bindings.hasErrors()) {
            return "form/form";
        }
        List<Category> categoriesList = donation.getCategories();
        String institution = donationServiceInterface.getInstitutionName(donation);
        System.out.println(institution);
        session.setAttribute("saveDonation", donation);
        model.addAttribute("donation", donation);
//        model.addAttribute("donationCategories", categoriesList);
        model.addAttribute("donationInstitution", institution);
//        log.info("instytucja" + " " +institution);
//        log.info(""+categoriesList);
        return "form/form_confirmation";
    }

    @GetMapping("/form_confirmation")
    public String processSaveToDb( HttpSession session){
        Donation donation = (Donation)session.getAttribute("saveDonation");
        donationServiceInterface.addDonation(donation);
        return "redirect:/index";
    }

}
