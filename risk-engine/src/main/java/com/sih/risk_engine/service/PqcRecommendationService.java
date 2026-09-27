package com.sih.risk_engine.service;

import org.springframework.stereotype.Service;

@Service
public class PqcRecommendationService {

    public String recommend(String algorithm) {

        if (algorithm == null || algorithm.isBlank()) {
            return "Manual cryptographic review required";
        }

        String alg = algorithm.toUpperCase();

        // Digital signature algorithms
        if (alg.contains("ECDSA")
                || alg.equals("DSA")) {
            return "Migrate to ML-DSA or SLH-DSA; consider dual-signature transition";
        }

        // Key exchange / public-key encryption
        if (alg.contains("RSA")
                || alg.contains("ECDH")
                || alg.contains("X25519")
                || alg.equals("DH")
                || alg.contains("ECC")) {
            return "Migrate to ML-KEM; consider a hybrid classical + ML-KEM deployment during transition";
        }

        // Symmetric cryptography
        if (alg.contains("AES")) {
            return "Prefer AES-256 and maintain crypto-agility";
        }

        // Already post-quantum
        if (alg.contains("ML-KEM")
                || alg.contains("KYBER")
                || alg.contains("ML-DSA")
                || alg.contains("DILITHIUM")
                || alg.contains("SLH-DSA")
                || alg.contains("SPHINCS")) {
            return "Already using post-quantum cryptography; verify implementation and parameter security";
        }

        return "Manual cryptographic review required";
    }
}