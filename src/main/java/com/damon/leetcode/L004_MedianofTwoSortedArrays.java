package com.damon.leetcode;

/*
 * 二分查找 转换成找第k小的数据 时间复杂度 O(log(m+n))
 *
 * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
 * 这里的 "/" 表示整除
 * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
 * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
 * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
 * 这样 pivot 本身最大也只能是第 k-1 小的元素
 * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
 * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
 * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
 */

public class L004_MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return getKth(nums1, nums2, len / 2 + 1);
        } else {
            return (getKth(nums1, nums2, len / 2) + getKth(nums1, nums2, len /2 + 1)) / 2.0;
        }
    }

    public int getKth(int[] nums1, int[] nums2, int k) {
        int idx1 = 0, idx2 = 0;

        while (true) {
            //越界后整个数组被排除的情况
            if (idx1 == nums1.length) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == nums2.length) {
                return nums1[idx1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            int newIdx1 = Math.min(nums1.length, idx1 + k / 2) - 1;//越界情况
            int newIdx2 = Math.min(nums2.length, idx2 + k / 2) - 1;

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