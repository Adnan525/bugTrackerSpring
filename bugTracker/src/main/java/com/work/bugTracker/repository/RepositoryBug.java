package com.work.bugTracker.repository;

import com.work.bugTracker.dataModel.BugModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryBug extends JpaRepository<BugModel, String> {
    @Override
    List<BugModel> findAll();

    @Query(value = "select b.bug_description,b.bug_name,b.status,b.uid from bugs b where b.uid = ?1", nativeQuery = true)
    List<BugModel> findByUID(String user);
}