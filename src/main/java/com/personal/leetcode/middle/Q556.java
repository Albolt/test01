package com.personal.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q556 {

    public static void main(String[] args) {
        int n = 2147483476;
//        2147483476
//        2147483647
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        StringBuffer x = new StringBuffer(String.valueOf(n));

        for (int i = x.length()-1; i > 0; i--) {

            if (x.charAt(i)>x.charAt(i-1)) {
                //获取第一个小于的值
                int ti = Integer.parseInt(String.valueOf(x.charAt(i-1)));

                String xEnd = x.substring(i-1);
                x.delete(i-1, x.length());

                List<Integer> xNum = new ArrayList<>();
                for (int j = 0; j < xEnd.length(); j++) {
                    xNum.add(Integer.parseInt(String.valueOf(xEnd.charAt(j))));
                }
                Collections.sort(xNum);
                for (int j = 0; j < xNum.size(); j++) {
                    if (xNum.get(j)>ti) {
                        x.append(xNum.get(j));
                        xNum.remove(j);
                        break;
                    }
                }
                for (int j = 0; j < xNum.size(); j++) {
                    x.append(xNum.get(j));
                }
                break;
            }
        }
        Long result = Long.valueOf(x.toString());
        if (result.equals(Long.valueOf(n)) || result>Integer.MAX_VALUE) return -1;
        return result.intValue();
    }
}
