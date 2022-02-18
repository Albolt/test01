package com.personal.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q560 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
