package com.personal.test01.everyOther;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

/**
 * @Creater albolt
 * @2020/4/26 下午5:04
 */

public class Md5 {

    private static final char[] hexDigest = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static String md5(String string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        while (true) {
            byte[] bytes = string.getBytes();
            md.update(bytes);
            byte[] newBytes = md.digest();
            char[] result = new char[newBytes.length * 2];
            int k = 0;
            for (int i = 0; i < newBytes.length; i++) {
                byte c = newBytes[i];
                result[k++] = hexDigest[c >>> 4 & 0xf];
                result[k++] = hexDigest[c & 0xf];
            }
            return new String(result);
        }
    }

    public static void main(String[] args) {
        String a = "i want you";
        try {
            System.out.println(md5(a));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
