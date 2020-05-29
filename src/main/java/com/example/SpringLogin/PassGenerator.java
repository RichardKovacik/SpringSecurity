package com.example.SpringLogin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PassGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String rawPass="heslo123";
        String encodedPass=encoder.encode(rawPass);
        System.out.println(encodedPass);
    }

}
