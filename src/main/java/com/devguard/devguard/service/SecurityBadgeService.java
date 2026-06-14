package com.devguard.devguard.service;

import com.devguard.devguard.dto.SecurityBadgeResponse;
import org.springframework.stereotype.Service;

@Service
public class SecurityBadgeService {

    public SecurityBadgeResponse getBadge() {

        SecurityBadgeResponse response =
                new SecurityBadgeResponse();

        response.setScore(81);
        response.setRiskLevel("LOW");
        response.setBadge("A");

        return response;
    }
}