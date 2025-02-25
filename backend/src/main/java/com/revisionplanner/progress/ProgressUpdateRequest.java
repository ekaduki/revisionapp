package com.revisionplanner.progress;

import lombok.Data;

@Data
public class ProgressUpdateRequest {
    private Integer confidenceLevel;
    private String notes;
    private String improvementPlan;
} 