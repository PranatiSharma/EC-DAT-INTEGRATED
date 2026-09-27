package com.sih.risk_engine.service;

import org.springframework.stereotype.Service;

@Service
public class RiskScoreService {

    public int calculateScore(
            String classification,
            boolean atRisk,
            String businessCriticality,
            Integer keyLength) {

        int score = 0;

        // 1. Quantum vulnerability
        if ("SHOR_VULNERABLE".equals(classification)) {
            score += 40;
        } else if ("GROVER_WEAKENED".equals(classification)) {
            score += 20;
        } else if ("POST_QUANTUM".equals(classification)) {
            score += 0;
        }

        // 2. Mosca risk
        if (atRisk) {
            score += 30;
        }

        // 3. Business criticality
        if ("CRITICAL".equalsIgnoreCase(businessCriticality)) {
            score += 30;
        } else if ("HIGH".equalsIgnoreCase(businessCriticality)) {
            score += 20;
        } else if ("MEDIUM".equalsIgnoreCase(businessCriticality)) {
            score += 10;
        }

        // Keep score within 0–100
        return Math.min(score, 100);
    }

    public String getSeverity(int score) {

        if (score >= 80) {
            return "CRITICAL";
        }

        if (score >= 60) {
            return "HIGH";
        }

        if (score >= 30) {
            return "MEDIUM";
        }

        return "LOW";
    }
}
