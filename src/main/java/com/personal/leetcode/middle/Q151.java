package com.personal.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class Q151 {

    public static void main(String[] args) {
        String x = "the sky is blue";
        reverseWords(x);
    }

    public static String reverseWords(String s) {
        String[] a = s.trim().split(" +");
        List<String> b = new ArrayList<>();
        for (int i = a.length-1; i > 0; i--) {
            b.add(a[i]);
        }

        return String.join(" ", b);
    }
}
