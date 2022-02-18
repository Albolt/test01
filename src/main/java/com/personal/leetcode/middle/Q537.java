package com.personal.leetcode.middle;

public class Q537 {

    public static void main(String[] args) {
        String a = "1+1i";
        String b = "1+1i";
        System.out.println(complexNumberMultiply(a, b));
    }

    public static String complexNumberMultiply(String num1, String num2) {

        String[] a = num1.split("\\+");
        String[] b = num2.split("\\+");

        int[] a1 = new int[]{Integer.valueOf(a[0]), Integer.valueOf(a[1].substring(0, a[1].length()-1))};
        int[] a2 = new int[]{Integer.valueOf(b[0]), Integer.valueOf(b[1].substring(0, b[1].length()-1))};
        int x = a1[0]*a2[0]-a1[1]*a2[1];
        int y = a1[0]*a2[1]+a1[1]*a2[0];
        return x+"+"+y+"i";
    }
}
