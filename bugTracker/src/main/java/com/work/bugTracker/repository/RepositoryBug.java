package com.work.bugTracker.repository;

import com.work.bugTracker.dataModel.BugModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryBug extends JpaRepository<BugModel, String> {
    @Override
    List<BugModel> findAll();
}
