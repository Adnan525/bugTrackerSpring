package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import com.work.bugTracker.dataModel.UserModel;
import com.work.bugTracker.repository.RepositoryBug;
import com.work.bugTracker.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Config implements CommandLineRunner {
    @Autowired
    private RepositoryUser opUser;

    @Autowired
    private RepositoryBug bugRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run executed");
        UserModel AdminUser = new UserModel(
                "developer","developer", "ROLE_admin");
        UserModel TesterUser = new UserModel(
                "tester","tester", "ROLE_tester");
        BugModel testBug = new BugModel("TestBug", "this is a test bug", "001");
        opUser.save(AdminUser);
        opUser.save(TesterUser);
        bugRepo.save(testBug);
    }
}
