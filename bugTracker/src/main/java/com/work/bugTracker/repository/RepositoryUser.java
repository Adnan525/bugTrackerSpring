package com.work.bugTracker.repository;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<UserModel, Long> {
    UserModel findByUserName(String username);
}
