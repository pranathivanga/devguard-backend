package com.devguard.devguard.controller;

import com.devguard.devguard.dto.CustomRuleRequest;
import com.devguard.devguard.service.CustomRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private CustomRuleService customRuleService;

    @PostMapping("/add")
    public String addRule(
            @RequestBody CustomRuleRequest request) {

        return customRuleService.addRule(request);
    }
}