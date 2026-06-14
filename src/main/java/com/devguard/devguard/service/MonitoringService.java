package com.devguard.devguard.service;

import com.devguard.devguard.model.TrackedRepository;
//import com.devguard.devguard.repository.TrackedRepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonitoringService {
//    @Autowired
//    private TrackedRepositoryRepository trackedRepositoryRepository;
@Scheduled(fixedRate = 21600000)
public void monitorRepositories() {

    System.out.println("Running scheduled repository monitoring...");

}

//        List<TrackedRepository> repos =
//                trackedRepositoryRepository.findAll();
//
//        for (TrackedRepository repo : repos) {
//            System.out.println(
//                    "Monitoring: " + repo.getRepoUrl());
//
//            repo.setLastScanTime(
//                    LocalDateTime.now());
//
//            trackedRepositoryRepository.save(repo);
//        }
//        System.out.println("Running scheduled repository monitoring...");
//    }
}