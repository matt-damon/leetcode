package com.damon.leetcode;

//
public class L004_MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    }

    public int findKth(int[] nums1, int[] nums2, int k) {

        int idx1 = 0, idx2 = 0;
        int res = 0;

        while (true) {


            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            int newIdx1 = Math.min(idx1 + k / 2, nums1.length) - 1;
            int newIdx2 = Math.min(idx2 + k / 2, nums2.length) - 1;

            if (nums1[newIdx1] <= nums2[newIdx2]) {
                k = k - (newIdx1 - idx1 + 1);
                idx1 = newIdx1 + 1;
            } else {
                k = k - (newIdx2 - idx2 + 1);
                idx2 = newIdx2 + 1;
            }
        }



    }
}
