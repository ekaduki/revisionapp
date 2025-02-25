package com.revisionplanner.progress;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "student_topic_progress")
public class StudentTopicProgress {
    @Id
    private UUID id;
    private String userId;
    private UUID topicId;
    private Integer confidenceLevel;
    private LocalDateTime lastReviewedAt;
    private Integer timeSpentMinutes;
    private String notes;
} 