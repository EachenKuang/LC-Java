package com.eachenkuang.leetcode;

import com.eachenkuang.tools.ListNode;

public class Lc83 {
    /**
     * 用两个指针来遍历
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, next = head.next;
        while (next != null) {
            if (pre.val == next.val) {
                // 删除重复节点
                pre.next = next.next;
                next = next.next;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }
        return head;
    }

    /**
     * 优化版本，使用一个指针即可完成
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
