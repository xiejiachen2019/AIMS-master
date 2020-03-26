package com.aims.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public MD5() {
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);

            String hashtext;
            for(hashtext = number.toString(16); hashtext.length() < 32; hashtext = "0" + hashtext) {
                ;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException(var5);
        }
    }
}
