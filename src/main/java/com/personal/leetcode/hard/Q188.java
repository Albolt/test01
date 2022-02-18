package com.personal.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q188 {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int x = 0;
        int y = 1;
        Integer result = 0;
        List<Integer> a = new ArrayList<>();
        while (true) {
            if (x>prices.length-1 || y>prices.length-1) break;
            if (prices[x]>prices[y]) {
                x = y;
                y = x+1;
                continue;
            } else {
                Integer sum = prices[y]-prices[x];
                while (true) {
                    if (y<prices.length-1 && prices[y+1]>prices[y]) {
                        sum+=prices[y+1]-prices[y];
                        y = y+1;
                    } else break;
                }
                a.add(sum);
                x = y+1;
                y = x+1;
            }
        }
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        for (int i = 0; i < k; i++) {
            if (i<a.size()) {
                result+=a.get(i);
            }
        }

        return result;
    }
}
