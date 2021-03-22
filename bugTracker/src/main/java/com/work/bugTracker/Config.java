package com.work.bugTracker;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class Config
{
    @Bean
    CommandLineRunner cmdRunner(OperationUser opUser)
    {
        return args->opUser.save(
                new UserModel("admin",
                        "admin",
                        0)
        );
    }
}
