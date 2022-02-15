package com.damon.leetcode;


/**
 * 123 -> 321
 * -123 -> -321
 * 120 -> 21
 * 需考虑溢出的情况
 *
 *    rev * 10 + mod <= 2147483647(Integer.MAX_VALUE)
 *
 */
public class L006_ReverseInteger {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int mod = x % 10;
            rev = rev * 10 + mod;//部分语言溢出会报错,java不会
            x = x / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int a = -1234;
        System.out.println(reverse(a));
        System.out.println(Integer.MAX_VALUE);
    }
}
