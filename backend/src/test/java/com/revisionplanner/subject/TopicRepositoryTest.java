package com.revisionplanner.subject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TopicRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TopicRepository topicRepository;

    private Subject subject;
    private UUID subjectId;

    @BeforeEach
    void setUp() {
        // Create and persist a subject first
        subject = new Subject();
        subjectId = UUID.randomUUID();
        subject.setId(subjectId);
        subject.setName("Mathematics");
        subject.setCode("0580");
        entityManager.persist(subject);
        entityManager.flush();
    }

    @Test
    void shouldPerformCRUDOperations() {
        // Create
        Topic topic = new Topic();
        topic.setId(UUID.randomUUID());
        topic.setName("Algebra");
        topic.setDescription("Basic algebra");
        topic.setLearningObjectives("Master algebraic operations");
        topic.setRecommendedHours(25);
        topic.setSubject(subject);

        Topic savedTopic = topicRepository.save(topic);
        entityManager.flush();

        // Read
        Optional<Topic> found = topicRepository.findById(savedTopic.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Algebra");

        // Update
        found.get().setDescription("Updated algebra description");
        Topic updated = topicRepository.save(found.get());
        assertThat(updated.getDescription()).isEqualTo("Updated algebra description");

        // Delete
        topicRepository.deleteById(updated.getId());
        Optional<Topic> deleted = topicRepository.findById(updated.getId());
        assertThat(deleted).isEmpty();
    }

    @Test
    void shouldFindTopicsBySubjectId() {
        // Create and save a topic
        Topic topic = new Topic();
        topic.setId(UUID.randomUUID());
        topic.setName("Algebra");
        topic.setSubject(subject);
        topicRepository.save(topic);
        entityManager.flush();

        // Test findBySubjectId
        List<Topic> topics = topicRepository.findBySubjectId(subjectId);
        assertThat(topics).hasSize(1);
        assertThat(topics.get(0).getName()).isEqualTo("Algebra");
    }

    @Test
    void shouldSearchTopicsByName() {
        // Create and save a topic
        Topic topic = new Topic();
        topic.setId(UUID.randomUUID());
        topic.setName("Advanced Algebra");
        topic.setSubject(subject);
        topicRepository.save(topic);
        entityManager.flush();

        // Test search functionality
        Page<Topic> searchResults = topicRepository.findByNameContainingIgnoreCase(
            "algebra", 
            PageRequest.of(0, 10)
        );
        
        assertThat(searchResults.getContent()).hasSize(1);
        assertThat(searchResults.getContent().get(0).getName()).isEqualTo("Advanced Algebra");
    }
} 