package com.damon.leetcode;


import javax.swing.text.StyledEditorKit;

/**
 * 最长回文子串，正反读都一样
 *
 */
public class L005_LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        return dp(s);
    }


    /**
     *  动态规划：在查找有很多重叠子问题的情况的最优解时有效。它将问题重新组合成子问题。为了避免多次解决这些子问题，
     *  它们的结果都逐渐被计算并被保存，从简单的问题直到整个问题都被解决
     *
     *  定义：
     *  P(i,j)=(S[i,j]是回文串)
     *
     *  状态转移方程如下：
     *
     *  基础情况
     *  P(i,i)=true   单字符
     *  P(i,i+1)=(Si==Si+1) 双字符
     *  推导
     *  P(i,j)=(P[i+1,j-1] and Si=Sj)
     */
    public static String dp(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLen = 1;//从1开始
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {//左坐标
                int j = i + len - 1;//右坐标
                if (j >= s.length()) {//越界
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = j - i < 2 ? true : dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    start = len > maxLen ? i : start;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止
     * 回文中心：子串长度为1或2的边界情况，共有2n-1个中心
     */

    public String expandAroundCenter(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i +1);

            int len  = Math.max(len1, len2);

            start = len > maxLen ? i - (len - 1) / 2 : start;
            maxLen = Math.max(maxLen, len);
        }
        return s.substring(start, start + maxLen);
    }


    private int expand(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }




    public static void main(String[] args) {
        longestPalindrome("ac");
    }
}
