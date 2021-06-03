package com.work.bugTracker;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUser extends JpaRepository<UserModel, Long> {
    UserModel findByUserName(String username);
}
