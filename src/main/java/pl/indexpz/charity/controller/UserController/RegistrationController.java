package pl.indexpz.charity.controller.UserController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.charity.controller.dto.UserDTO;
import pl.indexpz.charity.domain.service.AuthenticationService;
import pl.indexpz.charity.web.converters.UserConverter;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@Slf4j
@RequiredArgsConstructor
public class RegistrationController {

    private final AuthenticationService authenticationService;
    private final UserConverter userConverter;


    @GetMapping
    public String prepareRegistration(Model model){
        model.addAttribute("data", new UserDTO());
        return "register_login/register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("data") @Valid UserDTO data, BindingResult bindings){
        if(bindings.hasErrors()){
            return "register_login/register";
        }

        authenticationService.registerUser(userConverter.toUser(data.getUsername(), data.getPassword()));
        return "redirect:/login";
    }
}
