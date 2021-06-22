package com.work.bugTracker.repository;

import com.work.bugTracker.dataModel.BugModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryBug extends JpaRepository<BugModel, String> {
    @Override
    List<BugModel> findAll();
}
