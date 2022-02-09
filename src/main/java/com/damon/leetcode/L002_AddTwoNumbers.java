package com.damon.leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class L002_AddTwoNumbers {

    /**
     * 链表类小技巧，dummyNode，僵尸节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode curNode = dummyNode;

        int dig = 0;
        while (l1 != null || l2 !=null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int val = (val1 + val2 + dig) % 10;//当前位
            dig = (val1 + val2 + dig) / 10;//进位

            curNode = curNode.next = new ListNode(val);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        //最后判断进位
        if (dig > 0) {
            curNode.next = new ListNode(dig);
        }
        return dummyNode.next;
    }
}
