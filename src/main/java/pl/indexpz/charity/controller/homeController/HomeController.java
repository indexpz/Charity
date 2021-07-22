package pl.indexpz.charity.controller.homeController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.charity.domain.model.Donation;
import pl.indexpz.charity.domain.service.DonationServiceInterface;
import pl.indexpz.charity.domain.service.InstitutionServiceInterface;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final DonationServiceInterface donationServiceInterface;
    private final InstitutionServiceInterface institutionServiceInterface;


    @GetMapping("/")
    public String prepareHome(HttpSession session, Model model) {
        log.info("Start home/index.jsp");
//        Donation donation = new Donation();
//        session.setAttribute("saveDonation", donation);


        model.addAttribute("donationsSize", donationServiceInterface.getNumberOfDonations());
        model.addAttribute("donationQuantity", donationServiceInterface.getNumberOfBags());
        model.addAttribute("institutions", institutionServiceInterface.getAllInstitutions());
        return "index";
    }

    @PostMapping
    public String dHome(HttpSession session) {
        session.getAttribute("saveDonation");
        return "index";
    }


}
