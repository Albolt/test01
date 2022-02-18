package com.personal.leetcode.easy;

public class Q1309 {

    public static void main(String[] args) {
        String s = "1326#";
        System.out.println(freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (i+2<s.length() && s.charAt(i+2) == '#') {
                char a = (char)(Integer.parseInt(s.substring(i, i+2))+96);
                result += String.valueOf(a);
                i+=2;
            } else {
                char a = (char)(Integer.parseInt(s.substring(i, i+1))+96);
                result += String.valueOf(a);
            }
        }
        return result;
    }
}
