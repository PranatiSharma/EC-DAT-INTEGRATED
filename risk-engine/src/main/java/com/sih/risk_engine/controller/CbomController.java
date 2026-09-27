package com.sih.risk_engine.controller;

import com.sih.risk_engine.dto.CbomComponent;
import com.sih.risk_engine.dto.RiskAnalysisResponse;
import com.sih.risk_engine.service.BusinessCriticalityService;
import com.sih.risk_engine.service.CryptoClassificationService;
import com.sih.risk_engine.service.MoscaRiskService;
import com.sih.risk_engine.service.PqcRecommendationService;
import com.sih.risk_engine.service.RiskScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cbom")
public class CbomController {

    private final CryptoClassificationService classificationService;
    private final MoscaRiskService moscaRiskService;
    private final PqcRecommendationService recommendationService;
    private final BusinessCriticalityService businessCriticalityService;
    private final RiskScoreService riskScoreService;

    public CbomController(
            CryptoClassificationService classificationService,
            MoscaRiskService moscaRiskService,
            PqcRecommendationService recommendationService,
            BusinessCriticalityService businessCriticalityService,
            RiskScoreService riskScoreService) {

        this.classificationService = classificationService;
        this.moscaRiskService = moscaRiskService;
        this.recommendationService = recommendationService;
        this.businessCriticalityService = businessCriticalityService;
        this.riskScoreService = riskScoreService;
    }

    @PostMapping("/analyze")
    public RiskAnalysisResponse analyze(
            @RequestBody CbomComponent component) {

        String classification =
                classificationService.classify(
                        component.getAlgorithm()
                );

        double shelfLife =
                component.getShelfLifeYears();

        double migrationTime =
                component.getMigrationTimeYears();

        double crqcTime =
                component.getCrqcTimeYears();

        boolean atRisk =
                moscaRiskService.isAtRisk(
                        shelfLife,
                        migrationTime,
                        crqcTime
                );

        double margin =
                moscaRiskService.calculateMargin(
                        shelfLife,
                        migrationTime,
                        crqcTime
                );

        String businessCriticality =
                businessCriticalityService.calculate(
                        component.getBusinessCriticality(),
                        component.getInternetFacing(),
                        component.getHandlesPii()
                );

        int riskScore =
                riskScoreService.calculateScore(
                        classification,
                        atRisk,
                        businessCriticality,
                        component.getKeyLength()
                );

        String severity =
                riskScoreService.getSeverity(riskScore);

        String recommendation =
                recommendationService.recommend(
                        component.getAlgorithm()
                );

        return new RiskAnalysisResponse(
                component.getAlgorithm(),
                component.getKeyLength(),
                classification,
                atRisk,
                margin,
                businessCriticality,
                riskScore,
                severity,
                recommendation
        );
    }
}