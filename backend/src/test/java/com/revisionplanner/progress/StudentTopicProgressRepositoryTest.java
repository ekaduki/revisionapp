package com.revisionplanner.progress;

import com.revisionplanner.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestConfig.class)
@ActiveProfiles("test")
public class StudentTopicProgressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentTopicProgressRepository progressRepository;

    @Test
    void shouldPerformCRUDOperations() {
        // Create
        StudentTopicProgress progress = new StudentTopicProgress();
        progress.setId(UUID.randomUUID());
        progress.setUserId("user123");
        progress.setTopicId(UUID.randomUUID());
        progress.setConfidenceLevel(4);
        progress.setTimeSpentMinutes(60);
        progress.setNotes("Initial progress");
        progress.setLastReviewedAt(LocalDateTime.now());

        StudentTopicProgress savedProgress = progressRepository.save(progress);
        entityManager.flush();

        // Read
        Optional<StudentTopicProgress> found = progressRepository.findById(savedProgress.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getConfidenceLevel()).isEqualTo(4);

        // Update
        found.get().setConfidenceLevel(5);
        found.get().setNotes("Updated progress");
        StudentTopicProgress updated = progressRepository.save(found.get());
        assertThat(updated.getConfidenceLevel()).isEqualTo(5);
        assertThat(updated.getNotes()).isEqualTo("Updated progress");

        // Delete
        progressRepository.deleteById(updated.getId());
        Optional<StudentTopicProgress> deleted = progressRepository.findById(updated.getId());
        assertThat(deleted).isEmpty();
    }

    @Test
    void shouldFindProgressByUserId() {
        // Create and save progress
        StudentTopicProgress progress = new StudentTopicProgress();
        progress.setId(UUID.randomUUID());
        progress.setUserId("user123");
        progress.setTopicId(UUID.randomUUID());
        progress.setConfidenceLevel(4);
        progressRepository.save(progress);
        entityManager.flush();

        // Test findByUserId
        List<StudentTopicProgress> userProgress = progressRepository.findByUserId("user123");
        assertThat(userProgress).hasSize(1);
        assertThat(userProgress.get(0).getConfidenceLevel()).isEqualTo(4);
    }

    @Test
    void shouldFindProgressByTopicId() {
        UUID topicId = UUID.randomUUID();
        
        // Create and save progress
        StudentTopicProgress progress = new StudentTopicProgress();
        progress.setId(UUID.randomUUID());
        progress.setUserId("user123");
        progress.setTopicId(topicId);
        progress.setConfidenceLevel(4);
        progressRepository.save(progress);
        entityManager.flush();

        // Test findByTopicId
        List<StudentTopicProgress> topicProgress = progressRepository.findByTopicId(topicId);
        assertThat(topicProgress).hasSize(1);
        assertThat(topicProgress.get(0).getTopicId()).isEqualTo(topicId);
    }
} 