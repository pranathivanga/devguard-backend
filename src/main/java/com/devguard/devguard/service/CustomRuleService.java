package com.devguard.devguard.service;

import com.devguard.devguard.dto.CustomRuleRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomRuleService {

    public String addRule(CustomRuleRequest request) {

        return "Custom rule '" +
                request.getRuleName() +
                "' registered successfully.";
    }
}