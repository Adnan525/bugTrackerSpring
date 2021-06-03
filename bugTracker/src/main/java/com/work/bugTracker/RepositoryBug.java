package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBug extends JpaRepository<BugModel, Long> {
}
