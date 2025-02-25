package com.revisionplanner.progress;

import lombok.Data;
import java.util.UUID;

@Data
public class ProgressDTO {
    private UUID id;
    private UUID topicId;
    private Integer confidenceLevel;
    private Integer timeSpentMinutes;
    private String notes;
} 