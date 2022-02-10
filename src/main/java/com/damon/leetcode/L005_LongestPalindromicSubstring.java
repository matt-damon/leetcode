package com.damon.leetcode;


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
     *  推导：
     *  P(i,j)=(P[i+1,j-1] and Si=Sj)
     *
     *  基础情况：
     *  单字符：P(i,i)=true
     *  双字符：P(i,i+1)=(Si==Si+1)
     */
    public static String dp(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 1;//从1开始
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        //依次检查各个长度的子串
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {//左坐标
                int j = i + len - 1; //右坐标
                if (j >= s.length()) {//越界
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = (j - i < 2) ? true : dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    start = maxLen < len ? i : start;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        longestPalindrome("ac");
    }
}
