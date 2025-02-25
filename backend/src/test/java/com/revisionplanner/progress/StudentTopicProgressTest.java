package com.revisionplanner.progress;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class StudentTopicProgressTest {

    @Test
    void testProgressCreation() {
        StudentTopicProgress progress = new StudentTopicProgress();
        UUID id = UUID.randomUUID();
        UUID topicId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();

        progress.setId(id);
        progress.setUserId("user123");
        progress.setTopicId(topicId);
        progress.setConfidenceLevel(4);
        progress.setTimeSpentMinutes(60);
        progress.setNotes("Good progress");
        progress.setLastReviewedAt(now);

        assertEquals(id, progress.getId());
        assertEquals("user123", progress.getUserId());
        assertEquals(topicId, progress.getTopicId());
        assertEquals(4, progress.getConfidenceLevel());
        assertEquals(60, progress.getTimeSpentMinutes());
        assertEquals("Good progress", progress.getNotes());
        assertEquals(now, progress.getLastReviewedAt());
    }
} 