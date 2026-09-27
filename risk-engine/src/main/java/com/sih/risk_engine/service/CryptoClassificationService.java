package com.sih.risk_engine.service;

import org.springframework.stereotype.Service;

@Service
public class CryptoClassificationService {

    public String classify(String algorithm) {

        if (algorithm == null || algorithm.isBlank()) {
            return "UNKNOWN";
        }

        String alg = algorithm.toUpperCase();

        // Shor-vulnerable public-key cryptography
        if (alg.contains("RSA")
                || alg.contains("ECC")
                || alg.contains("ECDSA")
                || alg.contains("ECDH")
                || alg.contains("X25519")
                || alg.contains("DH")) {

            return "SHOR_VULNERABLE";
        }

        // Grover-weakened symmetric/hash cryptography
        if (alg.contains("AES")
                || alg.contains("SHA")
                || alg.contains("HMAC")) {

            return "GROVER_WEAKENED";
        }

        // Post-quantum cryptography
        if (alg.contains("ML-KEM")
                || alg.contains("KYBER")
                || alg.contains("ML-DSA")
                || alg.contains("DILITHIUM")
                || alg.contains("SLH-DSA")
                || alg.contains("SPHINCS")) {

            return "POST_QUANTUM";
        }

        return "UNKNOWN";
    }
}
