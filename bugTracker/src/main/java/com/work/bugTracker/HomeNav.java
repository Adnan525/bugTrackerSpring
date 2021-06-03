package com.work.bugTracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeNav {
    @GetMapping("/")
    public String home()
    {
        return "Home page for everyone";
    }
    @GetMapping("/user")
    public String user()
    {
        return "Successfully logged in as user";
    }
    @GetMapping("/admin")
    public String admin()
    {
        return "Successfully logged in as admin";
    }

}
