package com.devguard.devguard.controller;

import com.devguard.devguard.dto.DashboardSummary;
import com.devguard.devguard.model.ScanRecord;
//import com.devguard.devguard.model.TrackedRepository;
import com.devguard.devguard.repository.ScanRepository;
//import com.devguard.devguard.repository.TrackedRepositoryRepository;
import com.devguard.devguard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
//    @Autowired
//    private ScanRepository repository;
//    @Autowired
//    private TrackedRepositoryRepository trackedRepositoryRepository;

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
}