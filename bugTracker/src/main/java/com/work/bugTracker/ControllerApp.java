package com.work.bugTracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControllerApp {

    // Login form
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/")
    public RedirectView home()
    {
        return new RedirectView("/login");
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }

    @GetMapping("/tester")
    public String tester()
    {
        return "tester";
    }


//    @GetMapping("/")
//    public String home()
//    {
//        return "Home page for everyone";
//    }
//    @GetMapping("/user")
//    public String user()
//    {
//        return "Successfully logged in as user";
//    }
//    @GetMapping("/admin")
//    public String admin()
//    {
//        return "Successfully logged in as admin";
//    }

}
