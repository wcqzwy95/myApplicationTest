package com.mybatis.generator.util;

import org.apache.shiro.codec.Hex;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.Random;

public class RandomNumber {
    public static String getSaltMD(String password, String salt) {
        if (StringUtils.isEmpty(salt)) {
            Random random = new Random();
            StringBuilder builder = new StringBuilder(16);
            builder.append(random.nextInt(9999999)).append(random.nextInt(99999999));
            int length = builder.length();
            if (length<16) {
                for (int i=0; i<16-length; i++){
                    builder.append("0");
                }
            }
            salt = builder.toString();
        }
        password = md5Hex(password + salt);
        char[] chars = new char[48];
        for (int j=0; j<48; j += 3) {
            chars[j] = password.charAt(j / 3 * 2);
            char c = salt.charAt(j / 3);
            chars[j + 1] = c;
            chars[j + 2] = password.charAt(j / 3 * 2 + 1);
        }
        return String.valueOf(chars) + "," + salt;
    }
    @SuppressWarnings("unused")
    public static String md5Hex(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
}
