package com.example.banksystemproject.util;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IbanGenerator {

    public String generate() {
        StringBuilder start = new StringBuilder();
        Random value = new Random();

        RandomString string = new RandomString();
        String r1 = string.nextString().substring(0, 1).toUpperCase();
        String r2 = string.nextString().substring(0, 1).toUpperCase();
        start.append(r1).append(r2).append(" ");

        int count = 0;
        int n = 0;
        for (int i = 0; i < 12; i++) {
            if (count == 4) {
                start.append(" ");
                count = 0;
            } else {
                n = value.nextInt(10);
            }
            start.append(n);
            count++;

        }
        return start.toString();
    }
}
