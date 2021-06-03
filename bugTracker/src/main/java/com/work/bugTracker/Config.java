package com.work.bugTracker;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Config implements CommandLineRunner {
    @Autowired
    private RepositoryUser opUser;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run executed");
        UserModel AdminUser = new UserModel(
                "developer","developer", "admin");
        UserModel TesterUser = new UserModel(
                "tester","tester", "tester");
        opUser.save(AdminUser);
        opUser.save(TesterUser);
    }
}
