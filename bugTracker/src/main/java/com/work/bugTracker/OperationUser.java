package com.work.bugTracker;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationUser extends JpaRepository<UserModel, Long> {
}
