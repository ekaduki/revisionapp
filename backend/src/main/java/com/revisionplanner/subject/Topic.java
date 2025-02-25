package com.revisionplanner.subject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String learningObjectives;
    private Integer recommendedHours;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
} 