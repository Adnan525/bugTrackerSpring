package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import com.work.bugTracker.dataModel.PrimUser;
import com.work.bugTracker.repository.RepositoryBug;
import com.work.bugTracker.repository.RepositoryUser;
import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @GetMapping("/admin")
    public String admin(Model model)
    {
        List<BugModel> allBugs = repoBug.findAll();
        model.addAttribute("allbugs", allBugs);
        model.addAttribute("bug", new BugModel());
        model.addAttribute("user", new PrimUser());
        return "admin";
    }
    @PostMapping("/addbug")
    public RedirectView addBug(@ModelAttribute BugModel bug, Model model, HttpServletRequest request)
    {
        model.addAttribute("bug", bug);
        repoBug.save(bug);
        model.addAttribute("bugadded", true);
        if(request.isUserInRole("ROLE_admin"))
            return new RedirectView("/admin");
        else
            return new RedirectView("/tester");
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
    public String tester(Model model, Authentication auth)
    {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
//        Principal principal = request.getUserPrincipal();
        String allocatedUser = userDetails.getUsername();
        System.out.println("===============> user : "+allocatedUser);
        List<BugModel> assignedBugs = repoBug.findByUID(allocatedUser);
        System.out.println("===============> Listing bugs");
        for (BugModel b : assignedBugs) {
            System.out.println("===============> "+b.getBugName());

        }
        model.addAttribute("bug", new BugModel());
        model.addAttribute("assignedBugs", assignedBugs);
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
