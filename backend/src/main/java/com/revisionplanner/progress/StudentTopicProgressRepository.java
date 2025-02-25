package com.revisionplanner.progress;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface StudentTopicProgressRepository extends JpaRepository<StudentTopicProgress, UUID> {
    List<StudentTopicProgress> findByUserIdAndTopicId(String userId, UUID topicId);
    List<StudentTopicProgress> findByUserId(String userId);
    List<StudentTopicProgress> findByTopicId(UUID topicId);
} 