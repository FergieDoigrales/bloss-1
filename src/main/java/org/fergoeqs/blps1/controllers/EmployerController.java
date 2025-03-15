package org.fergoeqs.blps1.controllers;

import org.fergoeqs.blps1.models.Application;
import org.fergoeqs.blps1.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private final ApplicationService applicationService;

    public EmployerController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/vacancies/{vacancyId}/applications")
    public ResponseEntity<List<Application>> getApplicationsByVacancyId(@PathVariable Long vacancyId) {
        List<Application> applications = applicationService.getApplicationsByVacancyId(vacancyId);
        return ResponseEntity.ok(applications);
    }

    @PutMapping("/applications/{id}/accept")
    public ResponseEntity<Application> acceptApplication(@PathVariable Long id) {
        Application updatedApplication = applicationService.acceptApplication(id);
        return ResponseEntity.ok(updatedApplication);
    }

    @PutMapping("/applications/{id}/reject")
    public ResponseEntity<Application> rejectApplication(@PathVariable Long id) {
        Application updatedApplication = applicationService.rejectApplication(id);
        return ResponseEntity.ok(updatedApplication);
    }
}