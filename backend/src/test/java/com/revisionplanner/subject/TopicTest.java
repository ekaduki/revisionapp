package com.revisionplanner.subject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;

public class TopicTest {

    @Test
    void testTopicCreation() {
        Topic topic = new Topic();
        UUID id = UUID.randomUUID();
        UUID subjectId = UUID.randomUUID();
        
        Subject subject = new Subject();
        subject.setId(subjectId);
        subject.setName("Mathematics");

        topic.setId(id);
        topic.setName("Algebra");
        topic.setDescription("Basic algebraic operations");
        topic.setLearningObjectives("Understand and use algebraic notation");
        topic.setRecommendedHours(25);
        topic.setSubject(subject);

        assertEquals(id, topic.getId());
        assertEquals("Algebra", topic.getName());
        assertEquals("Basic algebraic operations", topic.getDescription());
        assertEquals("Understand and use algebraic notation", topic.getLearningObjectives());
        assertEquals(25, topic.getRecommendedHours());
        assertEquals(subject, topic.getSubject());
    }
} 