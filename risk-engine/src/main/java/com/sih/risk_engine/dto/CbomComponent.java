package com.sih.risk_engine.dto;

public class CbomComponent {

    private String name;
    private String type;
    private String algorithm;
    private Integer keyLength;
    private String language;
    private String filePath;
    private String version;

    // Mosca's theorem inputs
    private Double shelfLifeYears;
    private Double migrationTimeYears;
    private Double crqcTimeYears;

    // Business criticality inputs
    private Boolean internetFacing;
    private Boolean handlesPii;
    private String businessCriticality;

    public CbomComponent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Integer getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(Integer keyLength) {
        this.keyLength = keyLength;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getShelfLifeYears() {
        return shelfLifeYears;
    }

    public void setShelfLifeYears(Double shelfLifeYears) {
        this.shelfLifeYears = shelfLifeYears;
    }

    public Double getMigrationTimeYears() {
        return migrationTimeYears;
    }

    public void setMigrationTimeYears(Double migrationTimeYears) {
        this.migrationTimeYears = migrationTimeYears;
    }

    public Double getCrqcTimeYears() {
        return crqcTimeYears;
    }

    public void setCrqcTimeYears(Double crqcTimeYears) {
        this.crqcTimeYears = crqcTimeYears;
    }

    public Boolean getInternetFacing() {
        return internetFacing;
    }

    public void setInternetFacing(Boolean internetFacing) {
        this.internetFacing = internetFacing;
    }

    public Boolean getHandlesPii() {
        return handlesPii;
    }

    public void setHandlesPii(Boolean handlesPii) {
        this.handlesPii = handlesPii;
    }

    public String getBusinessCriticality() {
        return businessCriticality;
    }

    public void setBusinessCriticality(String businessCriticality) {
        this.businessCriticality = businessCriticality;
    }
}