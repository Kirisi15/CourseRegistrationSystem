package com.example.Course.Registration.System;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        String pt="Deenu";
        String hashedpassword=passwordEncoder.encode(pt);
        System.out.println(hashedpassword+";");
    }

}
