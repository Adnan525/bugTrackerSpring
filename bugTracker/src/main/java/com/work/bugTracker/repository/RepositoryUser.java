package com.work.bugTracker.repository;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Configuration
public interface RepositoryUser extends JpaRepository<UserModel, Long> {
    UserModel findByUserName(String username);
}
