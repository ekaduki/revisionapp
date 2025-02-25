package com.revisionplanner.subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
    List<Topic> findBySubjectId(UUID subjectId);
    Page<Topic> findBySubjectIdAndNameContainingIgnoreCase(UUID subjectId, String query, Pageable pageable);
    Page<Topic> findByNameContainingIgnoreCase(String query, Pageable pageable);
} 