package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import com.work.bugTracker.dataModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControllerApp {

    @Autowired
    private RepositoryBug repoBug;

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
    public String admin(Model model)
    {
        model.addAttribute("bug", new BugModel());
        return "admin";
    }
    @PostMapping("/addbug")
    public String greetingSubmit(@ModelAttribute BugModel bug, Model model)
    {
        model.addAttribute("bug", bug);
        repoBug.save(bug);
        model.addAttribute("bugadded", true);
        return "admin";
    }

    //working with postman
//    @PostMapping("/adduser")
//    public String addUser(@ModelAttribute("adduser") UserModel temp)
//    {
//        System.out.println("user found:"+temp.getUsername()+" password:"+temp.getPassword()+" with type:"+temp.getAuthorities().toString());
////        model.addAttribute("usermodel", user);
////        model.addAttribute("userAdded", true);
////        repo.save(trmp);
//        return "admin";
//    }

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
