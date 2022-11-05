package com.eachenkuang.leetcode;

import com.eachenkuang.arrays.Solution;
import com.eachenkuang.tools.ListNode;

/**
 * @author eachenkuang
 * @date 2022/11/5 10:45
 * @description:
 */
public class Lc206 {
    /**
     * 递归法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
