package com.devguard.devguard;

import com.devguard.devguard.engine.DetectionResult;
import com.devguard.devguard.engine.SecretDetector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DevguardApplication {

	public static void main(String[] args) {
		String testCode = """
                String password = "mySecret123";
                String apiKey = "abcd1234";
                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.test.signature";
                """;

		List<DetectionResult> results = SecretDetector.scan(testCode);

		for (DetectionResult r : results) {
			System.out.println(
					"Line: " + r.getLineNumber() +
							" | Type: " + r.getType() +
							" | Severity: " + r.getSeverity() +
							" | Match: " + r.getMatchedValue()
			);
		}
		SpringApplication.run(DevguardApplication.class, args);
	}

}
