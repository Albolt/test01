package com.personal.leetcode.middle;

public class Q1016 {

    public static void main(String[] args) {
        String s = "1";
        int n = 1;
        System.out.println(queryString(s, n));
    }

    public static boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String x = Integer.toBinaryString(i);
            if (s.contains(x)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
