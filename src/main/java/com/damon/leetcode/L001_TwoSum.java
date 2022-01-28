package com.damon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L001_TwoSum {

    //one-pass hashtable
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];

            if (indexMap.containsKey(num)) {
                return new int[]{i, indexMap.get(num)};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return null;
    }
}
