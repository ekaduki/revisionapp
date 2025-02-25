package com.revisionplanner.subject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;

public class SubjectTest {

    @Test
    void testSubjectCreation() {
        Subject subject = new Subject();
        UUID id = UUID.randomUUID();
        subject.setId(id);
        subject.setName("Mathematics");
        subject.setCode("0580");
        subject.setDescription("IGCSE Mathematics");

        assertEquals(id, subject.getId());
        assertEquals("Mathematics", subject.getName());
        assertEquals("0580", subject.getCode());
        assertEquals("IGCSE Mathematics", subject.getDescription());
    }
} 