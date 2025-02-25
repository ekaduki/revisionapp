package com.revisionplanner.progress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private StudentTopicProgressRepository progressRepository;

    @PostMapping
    public ResponseEntity<?> saveProgress(@RequestBody ProgressDTO progressDTO, Principal principal) {
        StudentTopicProgress progress = new StudentTopicProgress();
        progress.setId(UUID.randomUUID());
        progress.setUserId(principal.getName());
        progress.setTopicId(progressDTO.getTopicId());
        progress.setConfidenceLevel(progressDTO.getConfidenceLevel());
        progress.setTimeSpentMinutes(progressDTO.getTimeSpentMinutes());
        progress.setNotes(progressDTO.getNotes());
        progress.setLastReviewedAt(LocalDateTime.now());
        
        progressRepository.save(progress);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<StudentTopicProgress>> getProgress(Principal principal) {
        List<StudentTopicProgress> progress = progressRepository.findByUserId(principal.getName());
        return ResponseEntity.ok(progress);
    }
} 