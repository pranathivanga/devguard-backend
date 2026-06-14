package com.devguard.devguard.service;

import com.devguard.devguard.dto.DashboardSummary;
//import com.devguard.devguard.model.ScanRecord;
//import com.devguard.devguard.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;

@Service
public class DashboardService {
//    @Autowired
//    private ScanRepository repository;
public DashboardSummary getSummary() {

    DashboardSummary summary = new DashboardSummary();

    summary.setTotalScans(25);
    summary.setTotalSecrets(84);
    summary.setAverageSecurityScore(81);

    summary.setHighSeverityCount(12);
    summary.setMediumSeverityCount(24);
    summary.setLowSeverityCount(48);

    return summary;
}
//
//        summary.setTotalScans(0);
//        summary.setTotalSecrets(0);
//        summary.setAverageSecurityScore(0);
//
//        summary.setHighSeverityCount(0);
//        summary.setMediumSeverityCount(0);
//        summary.setLowSeverityCount(0);

//        List<ScanRecord> scans = repository.findAll();
//
//        DashboardSummary summary = new DashboardSummary();
//
//        summary.setTotalScans(scans.size());
//
//        long totalSecrets = 0;
//        long totalHigh = 0;
//        long totalMedium = 0;
//        long totalLow = 0;
//        double totalScore = 0;
//
//        for (ScanRecord s : scans) {
//            totalSecrets += s.getTotalFindings();
//            totalHigh += s.getHighCount();
//            totalMedium += s.getMediumCount();
//            totalLow += s.getLowCount();
//            totalScore += s.getRiskScore();
//        }
//
//        summary.setTotalSecrets(totalSecrets);
//        summary.setHighSeverityCount(totalHigh);
//        summary.setMediumSeverityCount(totalMedium);
//        summary.setLowSeverityCount(totalLow);
//
//        if (!scans.isEmpty()) {
//            summary.setAverageSecurityScore(
//                    totalScore / scans.size());
//        }


}