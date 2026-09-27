package com.sih.risk_engine.dto;

public class RiskAnalysisResponse {

    private String algorithm;
    private Integer keyLength;
    private String classification;
    private boolean atRisk;
    private double moscaMarginYears;
    private String businessCriticality;
    private int riskScore;
    private String severity;
    private String recommendation;

    public RiskAnalysisResponse() {
    }

    public RiskAnalysisResponse(
            String algorithm,
            Integer keyLength,
            String classification,
            boolean atRisk,
            double moscaMarginYears,
            String businessCriticality,
            int riskScore,
            String severity,
            String recommendation) {

        this.algorithm = algorithm;
        this.keyLength = keyLength;
        this.classification = classification;
        this.atRisk = atRisk;
        this.moscaMarginYears = moscaMarginYears;
        this.businessCriticality = businessCriticality;
        this.riskScore = riskScore;
        this.severity = severity;
        this.recommendation = recommendation;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public Integer getKeyLength() {
        return keyLength;
    }

    public String getClassification() {
        return classification;
    }

    public boolean isAtRisk() {
        return atRisk;
    }

    public double getMoscaMarginYears() {
        return moscaMarginYears;
    }

    public String getBusinessCriticality() {
        return businessCriticality;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getSeverity() {
        return severity;
    }

    public String getRecommendation() {
        return recommendation;
    }
}