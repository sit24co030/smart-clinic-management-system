
package com.smartclinic.smart_clinic_management_system.security;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TokenService {

    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public boolean isValidToken(String token) {
        return token != null && !token.isBlank();
    }
}
