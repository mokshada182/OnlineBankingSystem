package com.bank.main;


import com.bank.util.PasswordUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Banking System Backend");
        System.out.println("Password Utility Example:");
        String hashedPassword = PasswordUtils.hashPassword("example123");
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Verification: " + PasswordUtils.checkPassword("example123", hashedPassword));
    }
}