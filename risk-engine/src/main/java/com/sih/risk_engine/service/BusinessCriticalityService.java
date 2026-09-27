package com.sih.risk_engine.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessCriticalityService {

    public String calculate(
            String manualCriticality,
            Boolean internetFacing,
            Boolean handlesPii) {

        // Manual override takes priority
        if (manualCriticality != null && !manualCriticality.isBlank()) {
            return manualCriticality.toUpperCase();
        }

        boolean internet = Boolean.TRUE.equals(internetFacing);
        boolean pii = Boolean.TRUE.equals(handlesPii);

        // Both conditions = CRITICAL
        if (internet && pii) {
            return "CRITICAL";
        }

        // Either condition = HIGH
        if (internet || pii) {
            return "HIGH";
        }

        // Default
        return "MEDIUM";
    }
}