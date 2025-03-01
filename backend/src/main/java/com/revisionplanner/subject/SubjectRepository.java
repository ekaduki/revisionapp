package com.revisionplanner.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    // Add custom queries if needed
} 