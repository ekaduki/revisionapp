package com.revisionplanner.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public Page<Topic> getTopics(
            @RequestParam(required = false) UUID subjectId,
            @RequestParam(required = false, defaultValue = "") String query,
            Pageable pageable) {
        
        if (subjectId != null) {
            return topicRepository.findBySubjectIdAndNameContainingIgnoreCase(subjectId, query, pageable);
        }
        return topicRepository.findByNameContainingIgnoreCase(query, pageable);
    }
} 