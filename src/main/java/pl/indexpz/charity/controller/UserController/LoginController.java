package pl.indexpz.charity.controller.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

@GetMapping
    public String prepareLogin(){
    return "user_home_page/login";
}
}
