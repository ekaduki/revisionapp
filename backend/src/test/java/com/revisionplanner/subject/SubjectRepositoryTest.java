package com.revisionplanner.subject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void shouldSaveAndRetrieveSubject() {
        // Create
        Subject subject = new Subject();
        subject.setId(UUID.randomUUID());
        subject.setName("Chemistry");
        subject.setCode("0620");
        subject.setDescription("IGCSE Chemistry");

        Subject savedSubject = subjectRepository.save(subject);

        // Read
        Subject found = subjectRepository.findById(savedSubject.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Chemistry");
    }
} 