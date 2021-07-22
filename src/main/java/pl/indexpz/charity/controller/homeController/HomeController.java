package pl.indexpz.charity.controller.homeController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.charity.domain.model.Donation;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String prepareHome(HttpSession session) {
        log.info("Start home/index.jsp");
        Donation donation = new Donation();
        session.setAttribute("saveDonation", donation);
        return "index";
    }

@PostMapping
    public String dHome(HttpSession session){
        session.getAttribute("saveDonation");
        return "index";
}


}
