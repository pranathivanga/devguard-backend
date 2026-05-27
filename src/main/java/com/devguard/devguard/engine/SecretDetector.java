package com.devguard.devguard.engine;
import java.util.*;
import java.util.regex.Matcher;

public class SecretDetector {

    private static final List<SecretRule> RULES = List.of(

            new SecretRule(
                    "AWS Access Key",
                    "AKIA[0-9A-Z]{16}",
                    "HIGH",
                    "AWS access key detected"
            ),

            new SecretRule(
                    "JWT Token",
                    "eyJ[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]+",
                    "HIGH",
                    "JWT token detected"
            ),

            new SecretRule(
                    "Hardcoded Password",
                    "(?i)password\\s*=\\s*['\"].+?['\"]",
                    "MEDIUM",
                    "Hardcoded password in code"
            ),

            new SecretRule(
                    "API Key",
                    "(?i)api[_-]?key\\s*=\\s*['\"].+?['\"]",
                    "HIGH",
                    "API key exposed"
            ),

            new SecretRule(
                    "Private Key Block",
                    "-----BEGIN PRIVATE KEY-----",
                    "HIGH",
                    "Private key exposed"
            )
    );

    public static List<DetectionResult> scan(String content) {

        List<DetectionResult> results = new ArrayList<>();

        String[] lines = content.split("\n");

        for (int i = 0; i < lines.length; i++) {

            String line = lines[i];

            // 🔥 Ignore comments & empty lines
            if (isIgnorableLine(line)) {
                continue;
            }

            for (SecretRule rule : RULES) {

                Matcher matcher = rule.getPattern().matcher(line);

                while (matcher.find()) {

                    results.add(new DetectionResult(
                            i + 1,
                            rule.getName(),
                            rule.getSeverity(),
                            matcher.group(),
                            line.trim()
                    ));
                }
            }
        }

        return results;
    }

    // 🔥 New method for filtering noise
    private static boolean isIgnorableLine(String line) {
        String t = line.trim();

        return t.isEmpty() ||
                t.startsWith("//") ||
                t.startsWith("#") ||
                t.startsWith("*");
    }
}