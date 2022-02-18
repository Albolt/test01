package com.personal.leetcode.easy;

import java.util.Scanner;

public class Q125 {

    public static void main(String[] args) {
        String x = "aa";
        System.out.println(isPalindrome(x));
    }

    public static Boolean isPalindrome(String s) {
        if (s.length()==0) {
            return true;
        }
        int x = 0;
        int y = s.length()-1;
        while (true) {
            if (x>=y) {
                break;
            }
            if (!valid(s.charAt(x))) {
                x++;
                continue;
            }
            if (!valid(s.charAt(y))) {
                y--;
                continue;
            }
            if (Character.toUpperCase(s.charAt(x)) == Character.toUpperCase(s.charAt(y))) {
                x++;
                y--;
                continue;
            }
            return false;
        }
        return true;
    }

    public static Boolean valid(char a) {
        if ((a>=65 && a<=90) || (a>=97 && a<=122)) {
            return true;
        }
        if (a>=48 && a<=57) {
            return true;
        }
        return false;
    }

}
