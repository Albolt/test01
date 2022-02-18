package com.personal.leetcode.easy;

public class Q1758 {

    public static void main(String[] args) {
        String a = "10";
        System.out.println(minOperations(a));
    }

    public static int minOperations(String s) {
        Integer a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Integer.valueOf(s.substring(i, i + 1)) % 2 == i % 2) {
                a++;
            } else {
                b++;
            }
        }
        return Integer.min(a,b);
    }
}
