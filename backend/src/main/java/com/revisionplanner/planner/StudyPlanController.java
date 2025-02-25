package com.revisionplanner.planner;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import java.security.Principal;

@RestController
public class StudyPlanController {
    @GetMapping("/study-plan")
    public ResponseEntity<?> getStudyPlan(Principal principal) {
        return ResponseEntity.ok().build();
    }
} 