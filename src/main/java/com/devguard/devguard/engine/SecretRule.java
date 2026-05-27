package com.devguard.devguard.engine;

import java.util.regex.Pattern;

public class SecretRule {
    private String name;
    private Pattern pattern;
    private String severity;
    private String description;

    public SecretRule(String name, String regex, String severity, String description) {
        this.name = name;
        this.pattern = Pattern.compile(regex);
        this.severity = severity;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }
}
