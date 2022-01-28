package com.damon.leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = null, curNode = null;

        int dig = 0;
        while (l1 != null || l2 !=null) {
            curNode = (curNode == null) ? new ListNode() : (curNode.next = new ListNode());
            startNode = (startNode == null) ? curNode : startNode;

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int val = (val1 + val2 + dig) % 10;//当前位
            dig = (val1 + val2 + dig) / 10;//进位

            curNode.val = val;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        //最后判断进位
        if (dig > 0) {
            curNode = curNode.next = new ListNode();
            curNode.val = dig;
        }

        return startNode;
    }
}
