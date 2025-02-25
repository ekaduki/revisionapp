package com.revisionplanner.subject;

import lombok.Data;
import java.util.UUID;

@Data
public class TopicDTO {
    private UUID id;
    private UUID subjectId;
    private String name;
    private String description;
    private String learningObjectives;
    private Integer recommendedHours;

    public static TopicDTO fromTopic(Topic topic) {
        TopicDTO dto = new TopicDTO();
        dto.setId(topic.getId());
        dto.setSubjectId(topic.getSubject().getId());
        dto.setName(topic.getName());
        dto.setDescription(topic.getDescription());
        dto.setLearningObjectives(topic.getLearningObjectives());
        dto.setRecommendedHours(topic.getRecommendedHours());
        return dto;
    }

    public Topic toTopic() {
        Topic topic = new Topic();
        topic.setId(this.id);
        topic.setName(this.name);
        topic.setDescription(this.description);
        topic.setLearningObjectives(this.learningObjectives);
        topic.setRecommendedHours(this.recommendedHours);
        return topic;
    }
} 