package com.devguard.devguard.controller;

import com.devguard.devguard.dto.DashboardSummary;
import com.devguard.devguard.dto.RepositoryHealthResponse;
import com.devguard.devguard.model.ScanRecord;
//import com.devguard.devguard.model.TrackedRepository;
import com.devguard.devguard.repository.ScanRepository;
//import com.devguard.devguard.repository.TrackedRepositoryRepository;
import com.devguard.devguard.service.DashboardService;
import com.devguard.devguard.service.SecurityBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.devguard.devguard.service.SecurityBadgeService;
import com.devguard.devguard.dto.SecurityBadgeResponse;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
//    @Autowired
//    private ScanRepository repository;
//    @Autowired
//    private TrackedRepositoryRepository trackedRepositoryRepository;
@Autowired
private SecurityBadgeService securityBadgeService;
//    @GetMapping("/history")
//    public List<ScanRecord> getHistory() {
//        return repository.findAll();
//    }
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    public DashboardSummary getSummary() {
        return dashboardService.getSummary();
    }
    @GetMapping("/status")
    public String status() {
        return "DevGuard Analytics Engine Online";
    }
//    @PostMapping("/track")
//    public TrackedRepository trackRepository(
//            @RequestBody TrackedRepository repository) {
//
//        return trackedRepositoryRepository.save(repository);
//    }
@GetMapping("/badge")
public SecurityBadgeResponse getBadge() {
    return securityBadgeService.getBadge();
}
    @GetMapping("/health")
    public RepositoryHealthResponse getHealth() {

        RepositoryHealthResponse response =
                new RepositoryHealthResponse();

        response.setSecurityScore(81);
        response.setSecretsFound(5);
        response.setRiskLevel("LOW");
        response.setRecommendation(
                "Rotate exposed credentials and enable regular repository scanning.");

        return response;
    }
}