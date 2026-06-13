package com.devguard.devguard.service;

import com.devguard.devguard.engine.DetectionResult;
import org.springframework.stereotype.Service;

@Service
public class AiAnalysisService {

    public String generateFindingExplanation(DetectionResult finding) {
        return "This exposed credential may allow unauthorized access to sensitive services or infrastructure.";
    }

    public String generateRecommendation(DetectionResult finding) {
        return "Rotate the credential immediately and move it to environment variables or a secure secrets manager.";
    }
}