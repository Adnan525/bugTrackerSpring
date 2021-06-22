package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import com.work.bugTracker.dataModel.PrimUser;
import com.work.bugTracker.repository.RepositoryBug;
import com.work.bugTracker.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ControllerApp {

    @Autowired
    private RepositoryBug repoBug;

    @Autowired
    private RepositoryUser repoUser;

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

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/admin")
    public String admin(@RequestParam(name = "listbug", required = false, defaultValue = "connection lost to database, refresh page") Model model)
    {
//        List<BugModel> allBugs = repoBug.findAll();
//        model.addAttribute("listBug", allBugs.size()+" bug(s) have been reported");
        model.addAttribute("bug", new BugModel());
        model.addAttribute("user", new PrimUser());
        return "admin";
    }
    @PostMapping("/addbug")
    public RedirectView addBug(@ModelAttribute BugModel bug, Model model)
    {
        model.addAttribute("bug", bug);
        repoBug.save(bug);
        model.addAttribute("bugadded", true);
        return new RedirectView("/admin");
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute PrimUser user, Model model)
    {
        model.addAttribute("bug", new BugModel());
        model.addAttribute("user", user);
        repoUser.save(PrimUser.convert(user));
        model.addAttribute("useradded", true);
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
