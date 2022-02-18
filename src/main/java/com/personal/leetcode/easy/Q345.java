package com.personal.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q345 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        List<Integer> key = new ArrayList<>();
        List<String> value = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                key.add(i);
                value.add(String.valueOf(s.charAt(i)));
            }
        }
        for (int i = 0; i < key.size(); i++) {
            map.put(key.get(i), value.get(value.size()-1-i));
        }
        StringBuilder sb = new StringBuilder(s);
        map.forEach((k, v) -> {
            sb.replace(k, k+1, v);
        });
        return sb.toString();
    }

    private static boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
