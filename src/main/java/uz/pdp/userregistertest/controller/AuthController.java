package uz.pdp.userregistertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.userregistertest.model.Result;
import uz.pdp.userregistertest.payload.ActivationRequest;
import uz.pdp.userregistertest.payload.RegisterReq;
import uz.pdp.userregistertest.service.AuthService;
import uz.pdp.userregistertest.service.UserService;


import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @GetMapping(value = {"/sign/in"})
    public String getHomePage() {
        return "login";
    }

    @GetMapping(value = {"/sign/up"})
    public String getRegisterPage(Model model, RegisterReq registerReq) {
        model.addAttribute("registerReq", registerReq);
        return "register";
    }
    @GetMapping(value = {"/activate/user"})
    public String getActivationPage(Model model, ActivationRequest activationRequest) {
        model.addAttribute("activationRequest", activationRequest);
        return "login";
    }
    @PostMapping(value = {"/sign/up"})
    public String registerUser(@Valid RegisterReq registerReq,
                               BindingResult bindingResult,
                               Model model) {
        model.addAttribute("registerReq", registerReq);
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            userService.saveUser(registerReq);
            return "activation";
        }
    }



    @PostMapping("/activate/user")
    public String getActivePage(@Valid ActivationRequest activationRequest,
                                BindingResult bindingResult,
                                Model model) {
        model.addAttribute("activationRequest",activationRequest );
        if (bindingResult.hasErrors()) {
            return "activation";
        }
        else {
            authService.activate(activationRequest.getActiveCode());
            return "login";
        }
    }
}


