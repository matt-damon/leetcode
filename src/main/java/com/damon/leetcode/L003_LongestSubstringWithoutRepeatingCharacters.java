package com.damon.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 最长无重复字符子串
 * 1.暴力破解 遍历每个子串，s[i,j)  0<=i<j<=n，检查是否存在重复的字符串，出现重复时，j=i=i+1从新的子串开始  时间复杂度O(N2)
 * 2.滑动窗口 当子串出现重复时，i无须逐个移动，j无须回撤，通过减少重复检查子串来优化时间复杂度
 */
public class L003_LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
