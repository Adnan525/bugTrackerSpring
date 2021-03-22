package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import com.work.bugTracker.dataModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Config implements CommandLineRunner {
    @Autowired
    private OperationUser opUser;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run executed");
        UserModel user = new UserModel(
                "admin","admin", 0);
        opUser.save(user);

    }
}
