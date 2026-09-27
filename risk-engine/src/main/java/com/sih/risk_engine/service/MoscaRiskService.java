package com.sih.risk_engine.service;

import org.springframework.stereotype.Service;

@Service
public class MoscaRiskService {

    public boolean isAtRisk(
            double shelfLifeYears,
            double migrationTimeYears,
            double crqcTimeYears) {

        return (shelfLifeYears + migrationTimeYears) > crqcTimeYears;
    }

    public double calculateMargin(
            double shelfLifeYears,
            double migrationTimeYears,
            double crqcTimeYears) {

        return shelfLifeYears
                + migrationTimeYears
                - crqcTimeYears;
    }
}