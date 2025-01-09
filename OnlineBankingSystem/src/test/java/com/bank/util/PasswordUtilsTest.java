package com.bank.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {

    @Test
    void testHashPassword() {
        String plainPassword = "password123";
        String hashedPassword = PasswordUtils.hashPassword(plainPassword);
        assertNotNull(hashedPassword, "Hashed password should not be null");
    }

    @Test
    void testCheckPassword() {
        String plainPassword = "password123";
        String hashedPassword = PasswordUtils.hashPassword(plainPassword);
        assertTrue(PasswordUtils.checkPassword(plainPassword, hashedPassword), "Password should match the hash");
    }

    @Test
    void testCheckPasswordFailure() {
        String plainPassword = "password123";
        String wrongPassword = "wrongPassword";
        String hashedPassword = PasswordUtils.hashPassword(plainPassword);
        assertFalse(PasswordUtils.checkPassword(wrongPassword, hashedPassword), "Password should not match the hash");
    }
}
