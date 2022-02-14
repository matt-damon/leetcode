package com.damon.leetcode;


/**
 * 123 -> 321
 * -123 -> -321
 * 120 -> 21
 * 需考虑溢出的情况
 */
public class L006_ReverseInteger {


    public static int reverse(int x) {
        int rev = 0;
        int div = x;
        while (div != 0) {
            int mod = div % 10;
            int tmp = rev * 10 + mod;

            if ((tmp - mod) / 10 != rev) {
                return 0;
            }

            div = div / 10;
            rev = tmp;
        }
        return rev;
    }

    public static void main(String[] args) {
        int a = -1234;
        System.out.println(reverse(a));
        System.out.println(Integer.MAX_VALUE);
    }
}
