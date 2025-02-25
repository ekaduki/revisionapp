package com.revisionplanner.subject;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    private UUID id;
    private String name;
    private String code;
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Topic> topics;
} 